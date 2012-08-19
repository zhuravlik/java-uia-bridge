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
package zhuravlik.automation;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;
import com.sun.jna.platform.win32.*;
import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Point;
import java.util.List;
import zhuravlik.automation.jna.Oleacc;
import zhuravlik.automation.util.AutomationObject;
import zhuravlik.automation.util.NativeUtils;
import zhuravlik.automation.util.win32.MSAAObject;
import zhuravlik.automation.util.win32.Win32Object;

public class Test {
    
        
    static void click(String label, AutomationObject obj, int level) throws InterruptedException {
        List<AutomationObject> chld = obj.getChildItems();
        
        final Oleacc oleacc = Oleacc.INSTANCE;
        
        for (AutomationObject ch: chld) {
            for (int i = 0; i < level; i++) System.err.print("   ");
            /*System.err.println(((Win32Object)ch).getWndClass() + 
                    ", " + ((Win32Object)ch).isVisible() +
                    ", " + ((Win32Object)ch).getRectangle()[0].x +
                    ", " + ((Win32Object)ch).getRectangle()[0].y);
            */
            //WinDef.LRESULT res = ((Win32Object)ch).sendMessage(
            //        0x000E, new WinDef.WPARAM(0), new WinDef.LPARAM(0));
            
            WinDef.LRESULT res = ((Win32Object)ch).sendMessage(
                    0x000E, 0, null);
            
            
            int len = res.intValue();
            
            
            
            //WinDef.LPARAM val = new WinDef.LPARAM();            
            //Pointer val = new Pointer(len);
            //val.clear(len);
            byte[] data = new byte[len + 1];
            //PointerByReference p = new PointerByReference();
                        
            WinDef.LRESULT r2 = ((Win32Object)ch).sendMessage(0x000D,
                    len + 1, data);
            
            
            
            //Pointer pp = p.getValue();
            
            //String v = Native.toString(data);
            
            //System.err.println(((Win32Object)ch).getWndClass() +
            //        ", " + len);
            
            //byte[] v = val.getByteArray(0, len);
                                    
            
            
            if (Native.toString(data).equals(label)) {
                ((Win32Object)ch).mouseDown(new Point(0, 0));
                //Thread.sleep(1000);
                ((Win32Object)ch).mouseUp(new Point(0, 0));
            }
            
            click(label, ch, level + 1);            
            
            MSAAObject o = ((Win32Object)ch).toMSAAObject();
            Variant v = Dispatch.get(o.getDispatch(), "accName");
            //System.err.println(v.getString());
            
            //ActiveXComponent cmp = new ActiveXComponent("ff48dba4-60ef-4201-aa87-54103eef594e");
            //Dispatch dd = new Dispatch("CUIAutomation");
            //Dispatch dd = new Dispatch();
            //Dispatch dd2 = dd.QueryInterface("ff48dba4-60ef-4201-aa87-54103eef594e");
            
            final Ole32 ole32 = Ole32.INSTANCE;
            PointerByReference ptr2 = new PointerByReference();
            
            HRESULT h = ole32.CoCreateInstance(Ole32Util.getGUIDFromString("{ff48dba4-60ef-4201-aa87-54103eef594e}")
                    , Pointer.NULL, 1, Ole32Util.getGUIDFromString("{30cbe57d-d9d0-452a-ab13-7ac5ac4825ee}"), 
                    ptr2);
                        
            if (h.intValue() == 0) {
            
                System.err.println("UIA detected");
                
                Dispatch d2 = new Dispatch();
                d2.m_pDispatch = (int)Memory.nativeValue(ptr2.getValue());
                      
                //Dispatch d3 = new Dispatch();                
                //d3.m_pDispatch = (int)Memory.nativeValue(ptr2.getValue());
                //Variant r = new Variant(d3);
                
                //SafeArray sa = new SafeArray(Variant.VariantDispatch, 1);
                //sa.fromVariantArray(new Variant[] {r});
                
                //com.jacob.com.
                
                
                
                //r.putLongRef(10);
                
                int hw = (int)Memory.nativeValue(((Win32Object)ch).getHandle().getPointer());
               
                int pp = 5;
                //Variant r = new Variant(pp, true);
                System.err.println("HWND: " + hw);
                
                //Dispatch pr = new Dispatch();
                //Variant vvv = new Variant();
                //vvv.putDispatchRef(pr);
                
                Variant vi = new Variant();
                vi.putInt(hw);
                  
                int iii = 10;
                
                
                IntByReference ir = new IntByReference();     
                PointerByReference p = new PointerByReference(ir.getPointer());
                
                Variant vvv = new Variant();
                vvv.putIntRef((int)Memory.nativeValue(p.getPointer()));
                
                //Dispatch.call(d2, "ElementFromHandle", vi, vvv);
                Dispatch.call(d2, "GetRootElement", vvv);
            
            }
            System.err.println(((Win32Object)ch).getWndClass() +
                    ", " + Native.toString(data) +
                    ", " + v.getString());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
                
        final User32 usr = User32.INSTANCE;
        
        Win32Object obj = new Win32Object(null);
        
        click("Д&алее >", obj, 0);
        
        
        
        
        
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
