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

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.jnacom.ComObject;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Point;
import java.util.List;
import zhuravlik.automation.jna.*;
import zhuravlik.automation.util.AutomationObject;
import zhuravlik.automation.util.NativeUtils;


public class MSAAObject extends AutomationObject {
    
    Dispatch dispatch;
    //IAccessible iAccessible;
    
    /*private MSAAObject(Pointer dispPtr) {
        IUnknown iu = ComObject.wrapNativeInterface(dispPtr, IUnknown.class); 
        this.iAccessible = iu.queryInterface(IAccessible.class);
    }*/
    
    public MSAAObject(WinDef.HWND hwnd) {        
        /*final Oleacc oleacc = Oleacc.INSTANCE;
        
        Guid.GUID.ByReference guid = NativeUtils.iAccessibleGuid;
        PointerByReference ptr = new PointerByReference();            
            
        int r = oleacc.AccessibleObjectFromWindow(hwnd,
                new WinDef.DWORD(0), guid, ptr);
        
        IUnknown iu = ComObject.wrapNativeInterface(ptr.getValue(), IUnknown.class); 
        this.iAccessible = iu.queryInterface(IAccessible.class);*/

        final Oleacc oleacc = Oleacc.INSTANCE;
        
        Guid.GUID.ByReference guid = NativeUtils.iAccessibleGuid;
        PointerByReference ptr = new PointerByReference();
            
        int r = oleacc.AccessibleObjectFromWindow(hwnd,
                new WinDef.DWORD(0), guid, ptr);

        Pointer p = ptr.getValue();
        
        long mptr = Memory.nativeValue(p);

        Dispatch d = new Dispatch();
        
        d.m_pDispatch = (int) mptr;

        this.dispatch = d;
    }
    
    /*public IAccessible getIAccessible() {
        return iAccessible;
    }*/
    
    /*public Dispatch getDispatch() {
        return dispatch;
    } */
    
    public void doDefaultAction() {
        Dispatch.call(dispatch, "accDoDefaultAction");
        ComDef.Variant v = new ComDef.Variant();
        //v.vt = ComVarTypes.VT_I4;
        //v.u.lVal = 0;
        //iAccessible.accDoDefaultAction(0);
    }
    
    public int getChildCount() {
        /*LongByReference lng = new LongByReference();
        iAccessible.Get_accChildCount(lng);
        return lng.getValue();*/
        Variant v = Dispatch.get(dispatch, "accChildCount");
        return v.getInt();
    }
    
    public String getAccessibleName() {
        //PointerByReference ptr = new PointerByReference();
        //ComDef.Variant vv = new ComDef.Variant();
        //OleAut oa = OleAut.INSTANCE;
        //    oa.VariantInit(vv.getPointer());
        
        //vv.__VARIANT_NAME_1.__VARIANT_NAME_2.vt = ComVarTypes.VT_I4;
        //vv.__VARIANT_NAME_1.__VARIANT_NAME_2.u.lVal = 1;
        
        //vv.vt = ComVarTypes.VT_I4;
        //vv.longData = 1;
        
        //vv.u.s.vt = ComVarTypes.VT_I4;
        //vv.u.s.u.lVal = 0;
        //vv.vt = ComVarTypes.VT_I4;
        //vv.u.lVal = 0;
        
        //System.err.println("before get name");
        
        //HRESULT r = iAccessible.Get_accName(0, ptr);
        
        //System.err.println("after get name");
        
        //return ptr.getValue().getString(0, true);
                return Dispatch.get(dispatch, "accName").toString();
        //return "";
    }
    
    /*public MSAAObject getChild() {
        //PointerByReference ptr = new PointerByReference();
        //iAccessible.Get_accChild(0, ptr);
        //return new MSAAObject(ptr.getValue());
        Variant r = Dispatch.get(dispatch, "accChild");
        int ptr = r.getInt();
        
        
    }*/

    @Override
    public List<AutomationObject> getChildItems() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AutomationObject getParent() {
        throw new UnsupportedOperationException("Not supported yet.");
       /* PointerByReference ptr = new PointerByReference();
        iAccessible.Get_accParent(ptr);
        System.err.println(ptr.getValue() != null);
        return new MSAAObject(ptr.getValue());*/
        
        
    }

    @Override
    public Point[] getRectangle() {
        //throw new UnsupportedOperationException("Not supported yet.");
        /*Variant vv = new Variant();
        OleAut oa = OleAut.INSTANCE;
            oa.VariantInit(vv.getPointer());*/
        
        //vv.__VARIANT_NAME_1.__VARIANT_NAME_2.vt = ComVarTypes.VT_I4;
        //vv.__VARIANT_NAME_1.__VARIANT_NAME_2.u.lVal = 1;
        
        
        Point[] pts = new Point[2];
        Variant left = new Variant();
        Variant top = new Variant();
        Variant width = new Variant();
        Variant height = new Variant();
        Variant chld = new Variant();
        chld.putLong(0);
        chld.changeType((short)3);
        
        Dispatch.call(dispatch, "accLocation", left, top, width, height, chld);
        
        pts[0] = new Point((int)left.getLong(), (int)top.getLong());
        pts[1] = new Point((int)width.getLong(), (int)height.getLong());
        
        /*IntByReference left = new IntByReference();
        IntByReference top = new IntByReference();
        IntByReference width = new IntByReference();
        IntByReference height = new IntByReference();
        
        System.err.println("before get loc");
        iAccessible.accLocation(left, top, width, height, vv);
        System.err.println("after get loc");
        
        pts[0] = new Point((int)left.getValue(), (int)top.getValue());
        pts[1] = new Point((int)(left.getValue() + width.getValue()), (int)(top.getValue() + height.getValue()));
        */
        return pts;
    }

    @Override
    public void mouseDown(Point p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseUp(Point p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
