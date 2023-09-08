/*
    Copyright (C) 2012-2013 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
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
import java.awt.Rectangle;
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

    @Override
    public Rectangle getRectangle() {
        final User32 usr = User32.INSTANCE;
        RECT rect = new RECT();
        usr.GetWindowRect(handle, rect);

        //Point[] pts = new Point[2];

        //pts[0] = new Point(rect.left, rect.top);
        //pts[1] = new Point(rect.right, rect.bottom);

        return new Rectangle(rect.left, rect.top, rect.right - rect.left, rect.top - rect.bottom);
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
        return UIAObject.getFromHandle(handle);
    }
}
