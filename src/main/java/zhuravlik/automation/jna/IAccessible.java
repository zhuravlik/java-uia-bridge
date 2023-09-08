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

import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.jnacom.IID;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
//import zhuravlik.automation.jna.ComDef.Variant;

/**
 *
 * @author Администратор
 */
@IID("{618736E0-3C3D-11CF-810C-00AA00389B71}")
public interface IAccessible extends IUnknown {

    @VTID(7)
    HRESULT Get_accParent(PointerByReference pdisp);
    
    @VTID(8)
    HRESULT Get_accChildCount(LongByReference pcnt);
    
    @VTID(-5002)
    HRESULT Get_accChild(int childId, PointerByReference cdisp);
    
    //@VTID(-5003)
    @VTID(10)
    HRESULT Get_accName(int childId, PointerByReference pstr);
    
    @VTID(-5004)
    HRESULT Get_accValue(int childId, PointerByReference pstr);
    
    @VTID(-5005)
    HRESULT Get_accDescription(int childId, PointerByReference pstr);
    
    @VTID(-5006)
    HRESULT Get_accRole(int childId, PointerByReference roleId);
    
    @VTID(-5007)    
    HRESULT Get_accState(int childId, PointerByReference stateId);
    
    @VTID(-5008)
    HRESULT Get_accHelp(int childId, PointerByReference pstr);
    
    @VTID(-5009)
    HRESULT Get_accHelpTopic(PointerByReference pstr, int childId, PointerByReference topic);
    
    @VTID(-5010)
    HRESULT Get_accKeyboardShortcut(int childId, PointerByReference pstr);
    
    @VTID(-5011)
    HRESULT Get_accFocus(PointerByReference ptr);
    
    @VTID(-5012)
    HRESULT Get_accSelection(PointerByReference ptr);
    
    @VTID(-5013)
    HRESULT Get_accDefaultAction(int childId, PointerByReference pstr);
    
    @VTID(-5014)
    HRESULT accSelect(long flags, int childId);
    
    @VTID(22)
    HRESULT accLocation(IntByReference pxLeft,
        IntByReference pyTop,
        IntByReference pcxWidth,
        IntByReference pcyHeight,
        Variant varChild);
    
    @VTID(-5016)
    HRESULT accNavigate(long navDir, PointerByReference varStart,
        PointerByReference vv);
    
    
    
    @VTID(-5017)
    HRESULT accHitTest(long xLeft, long yTop, PointerByReference res);
    
    //@VTID(-5018)
    @VTID(27)
    HRESULT accDoDefaultAction(int childId);
    
    @VTID(-5003)
    HRESULT Set_accName(int childId, String str);
    
    @VTID(-5004)
    HRESULT Set_accValue(int childId, String str);
}
