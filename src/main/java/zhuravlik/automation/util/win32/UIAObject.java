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
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import zhuravlik.automation.jna.IUIAutomation;
import zhuravlik.automation.jna.IUIAutomationElement;
import zhuravlik.automation.util.AutomationObject;

public class UIAObject extends AutomationObject {
    
    IUIAutomationElement uiaelement;
    
    private static UIAObject uiaObjectFromPointerByReference(PointerByReference p) throws Exception {
        IUIAutomation au = getRootOleObject();
        //Dispatch el = new Dispatch();
        //el.m_pDispatch = (int)Memory.nativeValue(p.getValue());
        IUnknown iu2 = ComObject.wrapNativeInterface(p.getValue(), IUnknown.class);
        IUIAutomationElement elt = iu2.queryInterface(IUIAutomationElement.class);
        return new UIAObject(elt);
    }
    
    public static UIAObject getRootElement() throws Exception {
        IUIAutomation au = getRootOleObject();
        PointerByReference p = new PointerByReference();
        au.GetRootElement(p);
        return uiaObjectFromPointerByReference(p);
    }
    
    public static UIAObject getFocusedElement() throws Exception {
        IUIAutomation au = getRootOleObject();
        PointerByReference p = new PointerByReference();
        au.GetFocusedElement(p);
        return uiaObjectFromPointerByReference(p);
    }
    
    public static UIAObject getFromHandle(WinDef.HWND hwnd) throws Exception {
        IUIAutomation au = getRootOleObject();
        PointerByReference p = new PointerByReference();
        au.ElementFromHandle(hwnd, p);
        return uiaObjectFromPointerByReference(p);
    }        
    
    private UIAObject(IUIAutomationElement elt) {
        uiaelement = elt;
    }
    
    public static IUIAutomation getRootOleObject() throws Exception {
         final Ole32 ole32 = Ole32.INSTANCE;
            PointerByReference ptr2 = new PointerByReference();
            
            ole32.CoInitializeEx(Pointer.NULL, 2);
            
            WinNT.HRESULT h = ole32.CoCreateInstance(Ole32Util.getGUIDFromString("{ff48dba4-60ef-4201-aa87-54103eef594e}")
                    , Pointer.NULL, 1, Ole32Util.getGUIDFromString("{30cbe57d-d9d0-452a-ab13-7ac5ac4825ee}"), 
                    ptr2);
                        
            if (h.intValue() == 0) {            
                IUnknown iu = ComObject.wrapNativeInterface(ptr2.getValue(), IUnknown.class); 
                IUIAutomation au = iu.queryInterface(IUIAutomation.class);
                return au;
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
    public Rectangle getRectangle() {
        return getBoundingRectangle();        
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
        WinNT.HRESULT nm = uiaelement.get_CurrentHelpText(ppr);                
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
        WinNT.HRESULT nm = uiaelement.get_CurrentCulture(ppr);                
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
        WinNT.HRESULT nm = uiaelement.get_CurrentIsControlElement(ppr);                
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
    
    /*public class Placeholder0<T> {        
    }*/
    
    public class Placeholder<T> {    
        T p;
    }
        
    
    public <T> T getPattern(Class<T> clazz) throws ClassNotFoundException, NoSuchMethodException, 
            InstantiationException, IllegalAccessException, 
            IllegalArgumentException, InvocationTargetException {                                
        
        String className = clazz.getSimpleName();
        String patternName = className.replace("Pattern", "");
        
        ControlPattern patternKind = ControlPattern.valueOf(patternName);
        
        // some reflection magic to not enumerate all cases manually
        Class c = Class.forName("zhuravlik.automation.jna.patterns.raw.IUIAutomation" + patternName + "Pattern");
        
        IUnknown ptrn = getPatternRaw(patternKind);
        IUnknown qq = ptrn.queryInterface(c);        
        Object qqq = c.cast(qq);
        
        return clazz.getConstructor(c).newInstance(qqq);
    }    
    
    private IUnknown getPatternRaw(ControlPattern patternKind) {
        PointerByReference pp = new PointerByReference();       
        
        uiaelement.getCurrentPattern(patternKind.getValue(), pp);
        
        return ComObject.wrapNativeInterface(pp.getValue(), IUnknown.class);
    }
    
    /*public UIAObject FindFirst(TreeScope scope, ISearchCondition condition) {
        
    }
    
    public UIAObject[] FindAll(TreeScope scope, ISearchCondition condition) {
        
    }*/
}
