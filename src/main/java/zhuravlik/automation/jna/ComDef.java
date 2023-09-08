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