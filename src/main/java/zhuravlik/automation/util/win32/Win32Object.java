/*
   Copyright (C) 2012 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

   This library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General
   Public License along with this library; if not, write to the
   Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
   Boston, MA 02110-1301 USA
*/

package zhuravlik.automation.util.win32;

import com.sun.jna.Pointer;
//import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import zhuravlik.automation.jna.User32;
import zhuravlik.automation.util.AutomationObject;
import zhuravlik.automation.util.NativeUtils;


public class Win32Object extends AutomationObject {

    WinDef.HWND handle;

    public Win32Object(WinDef.HWND hwnd) {
        this.handle = hwnd;
    }

    public String getWndClass() {
        final User32 usr = User32.INSTANCE;
        char[] iname = new char[1000];
        usr.GetClassName(handle, iname, 1000);
        return NativeUtils.stripName(iname);
    }

    public boolean isVisible() {
        final User32 usr = User32.INSTANCE;

        return usr.IsWindowVisible(handle);
    }

    public Point[] getRectangle() {
        final User32 usr = User32.INSTANCE;
        RECT rect = new RECT();
        usr.GetWindowRect(handle, rect);

        Point[] pts = new Point[2];

        pts[0] = new Point(rect.left, rect.top);
        pts[1] = new Point(rect.right, rect.bottom);

        return pts;
    }
    
    public AutomationObject getParent() {
        final User32 usr = User32.INSTANCE;
        
        return new Win32Object(usr.GetParent(handle));
    }
    
    /*public WinDef.LRESULT sendMessage(
        int msg,
        WinDef.WPARAM wparam,
        WinDef.LPARAM lparam) {
        final User32 usr = User32.INSTANCE;
        
        return usr.SendMessage(handle, msg, wparam, lparam);
    }*/
    
    public WinDef.HWND getHandle() {
        return handle;
    }
    
    public void mouseDown(Point p) {
        sendMessage(0x201, 0, null);
    }
    
    public void mouseUp(Point p) {
        sendMessage(0x202, 0, null);
    }
    
    public WinDef.LRESULT sendMessage(
        int msg,
        int wparam,
        byte[] lparam) {
        final User32 usr = User32.INSTANCE;
        
        return usr.SendMessageA(handle, msg, wparam, lparam);
    }

    public List<AutomationObject> getChildItems() {

        final ArrayList<AutomationObject> objects = new ArrayList<AutomationObject>();

        final User32 usr = User32.INSTANCE;

        if (handle != null) {
            usr.EnumChildWindows(handle, new WinUser.WNDENUMPROC() {

                public boolean callback(WinDef.HWND hwnd, Pointer pntr) {
                    objects.add(new Win32Object(hwnd));
                    return true;
                }
            }, null);
        } else {
            usr.EnumWindows(new WinUser.WNDENUMPROC() {

                public boolean callback(WinDef.HWND hwnd, Pointer pntr) {
                    objects.add(new Win32Object(hwnd));
                    return true;
                }
            }, null);
        }

        return objects;
    }
    
    public MSAAObject toMSAAObject() {
        return new MSAAObject(handle);
    }
    
    public UIAObject toUIAObject() throws Exception {
        return new UIAObject(handle);
    }
}
