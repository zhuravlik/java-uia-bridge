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
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.Ole32Util;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinUser.POINT;
import com.sun.jna.platform.win32.jnacom.ComObject;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import zhuravlik.automation.jna.IUIAutomation;
import zhuravlik.automation.jna.IUIAutomationElement;
import zhuravlik.automation.util.AutomationObject;

public class UIAObject extends AutomationObject {
    
    IUIAutomationElement uiaelement;
    
    public UIAObject(WinDef.HWND hwnd) throws Exception {
        final Ole32 ole32 = Ole32.INSTANCE;
            PointerByReference ptr2 = new PointerByReference();
            
            ole32.CoInitializeEx(Pointer.NULL, 2);
            
            WinNT.HRESULT h = ole32.CoCreateInstance(Ole32Util.getGUIDFromString("{ff48dba4-60ef-4201-aa87-54103eef594e}")
                    , Pointer.NULL, 1, Ole32Util.getGUIDFromString("{30cbe57d-d9d0-452a-ab13-7ac5ac4825ee}"), 
                    ptr2);
                        
            if (h.intValue() == 0) {            
                IUnknown iu = ComObject.wrapNativeInterface(ptr2.getValue(), IUnknown.class); 
                IUIAutomation au = iu.queryInterface(IUIAutomation.class);
                PointerByReference res2 = new PointerByReference();
                au.ElementFromHandle(hwnd, res2);
                                
                Dispatch el = new Dispatch();
                el.m_pDispatch = (int)Memory.nativeValue(res2.getValue());
                
                IUnknown iu2 = ComObject.wrapNativeInterface(res2.getValue(), IUnknown.class); 
                
                uiaelement = iu2.queryInterface(IUIAutomationElement.class);                
            }
            else
                throw new Exception("COM error getting UIA for element: " + h);
    }

    @Override
    public List<AutomationObject> getChildItems() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AutomationObject getParent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Point[] getRectangle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseDown(Point p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseUp(Point p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String getName() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentName(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getAutomationId() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentAutomationId(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getFrameworkId() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentAutomationId(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getLocalizedControlType() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentLocalizedControlType(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getAcceleratorKey() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentAcceleratorKey(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getAccessKey() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentAccessKey(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getClassName() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentClassName(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getHelpText() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentHelpText(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getItemType() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentItemType(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getItemStatus() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentItemStatus(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getAriaRole() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentAriaRole(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getAriaProperties() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentAriaProperties(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public String getProviderDescription() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentProviderDescription(ppr);                
        return ppr.getValue().getString(0, true);
    }
    
    public Rectangle getBoundingRectangle() {
        RECT r = new RECT();
        WinNT.HRESULT nm = uiaelement.Get_CurrentBoundingRectangle(r);                
        
        return new Rectangle(r.left, r.top, r.right - r.left, r.bottom - r.bottom);
    }
    
    public int getProcessId() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentProcessId(ppr);                
        return ppr.getValue();
    }
    
    public int getCultureId() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentCulture(ppr);                
        return ppr.getValue();
    }
    
    public ControlType getControlType() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentControlType(ppr);                
        int cid = ppr.getValue();
        
        return ControlType.fromId(cid);
    }
    
    public OrientationType getOrientation() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentControlType(ppr);                
        int cid = ppr.getValue();
        
        return OrientationType.fromOrdinal(cid);
    }
    
    public boolean isHasKeyboardFocus() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentHasKeyboardFocus(ppr);                
        return ppr.getValue() != 0;
    }
    
    public boolean isKeyboardFocusable() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentIsKeyboardFocusable(ppr);                
        return ppr.getValue() != 0;
    }
    
    public boolean isEnabled() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.get_CurrentIsEnabled(ppr);                
        return ppr.getValue() != 0;
    }
    
    public boolean isControlElement() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentIsControlElement(ppr);                
        return ppr.getValue() != 0;
    }
    
    public boolean isContentElement() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentIsContentElement(ppr);                
        return ppr.getValue() != 0;
    }
    
    public boolean isPassword() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentIsPassword(ppr);         
        return ppr.getValue() != 0;
    }
    
    public boolean isOffscreen() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentIsOffscreen(ppr);         
        return ppr.getValue() != 0;
    }
    
    public boolean isRequiredForForm() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentIsRequiredForForm(ppr);         
        return ppr.getValue() != 0;
    }
    
    public boolean isDataValidForForm() {
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentIsDataValidForForm(ppr);         
        return ppr.getValue() != 0;
    }
    
    public WinDef.HWND getNativeWindowHandle() {
        PointerByReference ppr = new PointerByReference();
        WinNT.HRESULT nm = uiaelement.Get_CurrentNativeWindowHandle(ppr);
        return new WinDef.HWND(ppr.getValue());
    }
    
    
    public Point getClickablePoint() {
        POINT p = new POINT();
        IntByReference ppr = new IntByReference();
        WinNT.HRESULT nm = uiaelement.getClickablePoint(p, ppr);
       if (ppr.getValue() != 0)
           return new Point(p.x, p.y);
       else
           return null;
    }
    
    public void setFocus() {
        uiaelement.setFocus();
    }
    
    /*public UIAObject FindFirst(TreeScope scope, ISearchCondition condition) {
        
    }
    
    public UIAObject[] FindAll(TreeScope scope, ISearchCondition condition) {
        
    }*/
}
