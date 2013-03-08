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

import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinDef.WORD;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;

/**
 *
 * @author Администратор
 */
/*public interface ComDef {

    public static class Variant extends Structure {
        
        public Variant() {this.setAlignType(ALIGN_NONE);}
        
        public static class ByValue extends Variant implements Structure.ByValue {}
        
        public UNION1 __VARIANT_NAME_1 = new UNION1();
        IntByReference decVal;
        
        @Override
        public void read() {
            this.__VARIANT_NAME_1.setType(UNION1.STRUCT1.class);
            super.read();
        }
        
        public static class UNION1 extends Union {   
            
            public STRUCT1 __VARIANT_NAME_2 = new STRUCT1(); 
            
            public static class STRUCT1 extends Structure {

                public STRUCT1() {this.setAlignType(ALIGN_NONE);}
                
                public int vt;
                public WORD wReserved1;
                public WORD wReserved2;
                public WORD wReserved3;
                
                public UNION __VARIANT_NAME_3 = new UNION();
                
                @Override
                public void read() {
                    __VARIANT_NAME_3.setType(long.class);
                    super.read();
                }

                public static class UNION extends Union {
                    public long lVal;
                    public byte bVal;
                    public short iVal;
                    public float fltVal;
                    public double dblVal;
                    public boolean boolVal;
                    public WString bstrVal;
                    public PointerByReference punkVal;
                    public ByteByReference pbVal;
                    public ShortByReference piVal;
                    public LongByReference plVal;
                    public FloatByReference pfltVal;
                    public DoubleByReference pdblVal;
                    public char cVal;
                    public int intVal;
                    public IntByReference pintVal;
                }
            }
        }
    }
}*/