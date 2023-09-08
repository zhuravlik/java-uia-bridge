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

package zhuravlik.automation.jna;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.WinUser.POINT;
import com.sun.jna.platform.win32.jnacom.IID;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

@IID("{d22108aa-8ac5-49a5-837b-37bbb3d7591e}")
public interface IUIAutomationElement extends IUnknown {
    //30=wndclass
    //29=automation_id
    //40=framework_id
    //51=[ (wtf?)
    
    
    /*
     *     procedure FindFirst(const scope: TreeScope; const condition: IUIAutomationCondition; var retval found: IUIAutomationElement): HRESULT;;
    procedure FindAll(const scope: TreeScope; const condition: IUIAutomationCondition; var retval found: IUIAutomationElementArray): HRESULT;;
     */
    
    @VTID(3)
    HRESULT  setFocus();
    
    @VTID(5)
    HRESULT findFirst(
            int scope,
            Pointer condition,
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(6)
    HRESULT findAll(
            int scope,
            Pointer condition,
  /*[out, retval]*/  PointerByReference retVal
    );
    
    //    procedure GetCurrentPatternAs(const patternId: Integer; const riid: GUID; var retval patternObject: out): HRESULT;;
    
    /*@VTID(14)
    HRESULT getCurrentPatternAs(
            int patternId,
    PointerByReference retVal
    );*/
    
    
    //    procedure GetCurrentPattern(const patternId: Integer; var retval patternObject: IUnknown): HRESULT;;
    
    @VTID(16)
    HRESULT getCurrentPattern(
            int patternId,
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(20)
    HRESULT get_CurrentProcessId(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(21)
    HRESULT get_CurrentControlType(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(22)
    HRESULT get_CurrentLocalizedControlType(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(23)
    HRESULT get_CurrentName(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(24)
    HRESULT get_CurrentAcceleratorKey(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(25)
    HRESULT get_CurrentAccessKey(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(26)
    HRESULT get_CurrentHasKeyboardFocus(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(27)
    HRESULT get_CurrentIsKeyboardFocusable(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(28)
    HRESULT get_CurrentIsEnabled(
  /*[out, retval]*/  IntByReference retVal
    );    
    
    @VTID(29)
    HRESULT get_CurrentAutomationId(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(30)
    HRESULT get_CurrentClassName(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(31)
    HRESULT get_CurrentHelpText(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(32)
    HRESULT get_CurrentCulture(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(33)
    HRESULT get_CurrentIsControlElement(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(34)
    HRESULT Get_CurrentIsContentElement(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(35)
    HRESULT Get_CurrentIsPassword(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(36)
    HRESULT Get_CurrentNativeWindowHandle(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(37)
    HRESULT Get_CurrentItemType(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(38)
    HRESULT Get_CurrentIsOffscreen(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(39)
    HRESULT Get_CurrentOrientation(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(40)
    HRESULT get_CurrentFrameworkId(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(41)
    HRESULT Get_CurrentIsRequiredForForm(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(42)
    HRESULT Get_CurrentItemStatus(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(43)
    HRESULT Get_CurrentBoundingRectangle(
  /*[out, retval]*/  RECT retVal
    );
    
    @VTID(44)
    HRESULT Get_CurrentLabeledBy(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(45)
    HRESULT Get_CurrentAriaRole(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(46)
    HRESULT Get_CurrentAriaProperties(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(47)
    HRESULT Get_CurrentIsDataValidForForm(
  /*[out, retval]*/  IntByReference retVal
    );
    
    @VTID(48)
    HRESULT Get_CurrentControllerFor(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(49)
    HRESULT Get_CurrentDescribedBy(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(50)
    HRESULT Get_CurrentFlowsTo(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(51)
    HRESULT Get_CurrentProviderDescription(
  /*[out, retval]*/  PointerByReference retVal
    );
    
    @VTID(52)
    HRESULT getClickablePoint(
        POINT clickable,
        IntByReference ok
    );
}


/*
 * Get_CurrentClassName(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentHelpText(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentCulture(var retval retVal: Integer): HRESULT;;
    procedure Get_CurrentIsControlElement(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentIsContentElement(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentIsPassword(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentNativeWindowHandle(var retval retVal: out): HRESULT;;
    procedure Get_CurrentItemType(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentIsOffscreen(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentOrientation(var retval retVal: OrientationType): HRESULT;;
    procedure Get_CurrentFrameworkId(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentIsRequiredForForm(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentItemStatus(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentBoundingRectangle(var retval retVal: tagRECT): HRESULT;;
    procedure Get_CurrentLabeledBy(var retval retVal: IUIAutomationElement): HRESULT;;
    procedure Get_CurrentAriaRole(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentAriaProperties(var retval retVal: WideString): HRESULT;;
    procedure Get_CurrentIsDataValidForForm(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentControllerFor(var retval retVal: IUIAutomationElementArray): HRESULT;;
    procedure Get_CurrentDescribedBy(var retval retVal: IUIAutomationElementArray): HRESULT;;
    procedure Get_CurrentFlowsTo(var retval retVal: IUIAutomationElementArray): HRESULT;;
    procedure Get_CurrentProviderDescription(var retval retVal: WideString): HRESULT;;
   
 */
