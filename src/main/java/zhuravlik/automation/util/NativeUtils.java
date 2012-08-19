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
package zhuravlik.automation.util;

import com.sun.jna.platform.win32.Guid;

public class NativeUtils {
    
    public static Guid.GUID.ByReference iUnknownGuid = guidFromArray(new Object[] {0x00000000,	0x0000,	0x0000,
            new Object[] {0x0C0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x46}});
       
    public static Guid.GUID.ByReference iAccessibleGuid = guidFromArray(new Object[] {0x618736E0,	0x3C3D,	0x11CF,
            new Object[] {0x81, 0xC, 0x0, 0xAA, 0x0, 0x38, 0x9B, 0x71}});
    
    public static String stripName(char[] name) {
        int i = 0;
        while (name[i] != '\0') {
            i++;
        }

        char[] name1 = new char[i];
        System.arraycopy(name, 0, name1, 0, i);
        return new String(name1);        
    }
    
    public static Guid.GUID.ByReference guidFromArray(Object[] vals) {
        Guid.GUID.ByReference guid = new Guid.GUID.ByReference();
        guid.Data1 = (Integer)vals[0];
        guid.Data2 = ((Integer)vals[1]).shortValue();
        guid.Data3 = ((Integer)vals[2]).shortValue();
        guid.Data4 = new byte[8];
        
        Object[] arr = (Object[])vals[3];
        for (int i = 0; i < 8; i++)
            guid.Data4[i] = ((Integer)arr[i]).byteValue();
        
        return guid;
    }
}
