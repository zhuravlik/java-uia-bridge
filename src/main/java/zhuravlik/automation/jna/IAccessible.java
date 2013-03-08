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
