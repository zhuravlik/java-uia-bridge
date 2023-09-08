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
package zhuravlik.automation.util;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.jnacom.ComObject;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class NativeUtils {
    
    public static Guid.GUID.ByReference iUnknownGuid = guidFromArray(new Object[] {0x00000000,	0x0000,	0x0000,
            new Object[] {0x0C0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x46}});
       
    public static Guid.GUID.ByReference iAccessibleGuid = guidFromArray(new Object[] {0x618736E0,	0x3C3D,	0x11CF,
            new Object[] {0x81, 0xC, 0x0, 0xAA, 0x0, 0x38, 0x9B, 0x71}});
    
    public static String stripName(char[] name) {
        int i = 0;
        while (i < name.length && name[i] != '\0') {
            i++;
        }

        char[] name1 = new char[i];
        System.arraycopy(name, 0, name1, 0, i);
        return new String(name1);        
    }
    
    public static String unknownLengthStringFromPointer(Pointer p) {
        char c;
        ArrayList<Character> lst = new ArrayList<Character>();
        
        int i = 0;
        while (true) {
            c = p.getChar(i);
            lst.add(c);
            if (c == '\0')
                break;
            i++;
        }
        
        char[] arr = new char[lst.size()];
        
        for (int j = 0; j < lst.size(); j++)
            arr[j] = lst.get(j);
        
        
        
        return new String(arr);
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
    
    public static Pointer UnwrapNativeComInterface(IUnknown com) throws Exception {
        ComObject comObj = (ComObject) Proxy.getInvocationHandler((Proxy)com);
        Field fld = comObj.getClass().getDeclaredField("_InterfacePtr");
        fld.setAccessible(true);
        return (Pointer)fld.get(comObj);
    }
}
