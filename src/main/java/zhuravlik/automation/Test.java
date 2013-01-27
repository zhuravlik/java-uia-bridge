/*
   Copyright (C) 2012-2013 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

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
package zhuravlik.automation;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;
import com.sun.jna.platform.win32.*;
import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.jnacom.ComObject;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Point;
import java.lang.reflect.Method;
import java.util.List;
import zhuravlik.automation.jna.IUIAutomation;
import zhuravlik.automation.jna.IUIAutomationElement;
import zhuravlik.automation.jna.OleAut;
import zhuravlik.automation.jna.Oleacc;
import zhuravlik.automation.jna.patterns.WindowPattern;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationWindowPattern;
import zhuravlik.automation.util.AutomationObject;
import zhuravlik.automation.util.NativeUtils;
import zhuravlik.automation.util.win32.*;

public class Test {
    
        
    static void click(String label, AutomationObject obj, int level) throws Exception {
                        
        List<AutomationObject> chld = obj.getChildItems();
        
        final Oleacc oleacc = Oleacc.INSTANCE;
        
        for (AutomationObject ch: chld) {
            for (int i = 0; i < level; i++) System.err.print("   ");
            
            WinDef.LRESULT res = ((Win32Object)ch).sendMessage(
                    0x000E, 0, null);                        
            int len = res.intValue();
            byte[] data = new byte[len + 1];                        
            WinDef.LRESULT r2 = ((Win32Object)ch).sendMessage(0x000D,
                    len + 1, data);
                                    
            //System.err.println("> " + Native.toString(data));
                        
            if (Native.toString(data).equals(label)) {
                System.err.println("FOUND");
                ((Win32Object)ch).mouseDown(new Point(0, 0));
                ((Win32Object)ch).mouseUp(new Point(0, 0));
            }
            
            //click(label, ch, level + 1);            
            
            
            //MSAAObject o = ((Win32Object)ch).toMSAAObject();                                    
            UIAObject uo = ((Win32Object)ch).toUIAObject();
            
            String nm = uo.getName();
            ControlType ct = uo.getControlType();
            if (nm.contains("NetBeans") && ct == ControlType.Window) {
                //IUIAutomationWindowPattern ptrn = uo.<IUIAutomationWindowPattern>getPattern(IUIAutomationWindowPattern.class);                
                
                WindowPattern ptrn = uo.getPattern(WindowPattern.class);                
                ptrn.setVisualState(WindowVisualState.Minimized);
            }
            //uo.getCurrentProcessId();
            Method[] allM = uo.getClass().getMethods();
            
            for (Method m: allM) {
                if ((m.getName().startsWith("get") || m.getName().startsWith("is")) 
                        && m.getParameterTypes().length == 0) {
                    try {                                                
                        
                        System.err.print(m.getName() + ": " + m.invoke(uo) + ", ");
                    }
                    catch (Exception e) { System.err.print(m.getName() + ": FAIL: " + e.getMessage() + ", ");}
                }
            }
            
            System.err.println();
            
            /*System.err.println("CAPTION: " + uo.getCurrentName());                        
            
            System.err.println(((Win32Object)ch).getWndClass() +
                    ", " + Native.toString(data));*/
            
            //click(label, ch, level + 1);
        }
        
        
    }
    
    public static void main(String[] args) throws Exception {
                
        
        final User32 usr = User32.INSTANCE;
        
        Win32Object obj = new Win32Object(null);
        
        click("&Далее >", obj, 0);
        
        
        
        
        /*Thread.sleep(1000);
        click("Д&алее >", obj, 0);
        Thread.sleep(1000);
        click("&Готово", obj, 0);*/
        /*click("Все &программы", obj, 0);
        Thread.sleep(1000);
        click("Стандартные", obj, 0);
        Thread.sleep(1000);
        click("Paint", obj, 0);*/
        /*List<AutomationObject> chld = obj.getChildItems();
        
        for (AutomationObject ch: chld) {
            System.err.println(((Win32Object)ch).getWndClass());
            
            List<AutomationObject> chld2 = ch.getChildItems();
            
            for (AutomationObject ch2: chld2)
                System.err.println("   " + ((Win32Object)ch2).getWndClass());
        }*/
        
        /*usr.EnumWindows(new WinUser.WNDENUMPROC() {
            public boolean callback(WinDef.HWND hwnd, Pointer data) {
                char[] name = new char[1000];
                
                usr.GetClassName(hwnd, name, 1000);
                                                
                System.err.println("WndClass: " 
                        + NativeUtils.stripName(name));
                
                usr.EnumChildWindows(hwnd, new WinUser.WNDENUMPROC() {

                    public boolean callback(HWND hwnd, Pointer pntr) {
                        char[] iname = new char[1000];
                
                        usr.GetClassName(hwnd, iname, 1000);
                        System.err.println("   WndClass: "
                                + NativeUtils.stripName(iname));
                        
                        return true;
                    }
                }, null);
                
                return true;
            }
        }, null);*/
    }
}
