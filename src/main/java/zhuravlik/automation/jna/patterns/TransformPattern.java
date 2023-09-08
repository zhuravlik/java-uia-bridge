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
package zhuravlik.automation.jna.patterns;

import com.sun.jna.ptr.IntByReference;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationTransformPattern;

/**
 *
 * @author Администратор
 */
public class TransformPattern {
    private IUIAutomationTransformPattern rawPattern;
    
    public TransformPattern(IUIAutomationTransformPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void move(double x, double y) {
        rawPattern.Move(x, y);
    }
    
    public void resize(double width, double height) {
        rawPattern.Resize(width, height);
    }
    
    public void rotate(double degrees) {
        rawPattern.Rotate(degrees);
    }
    
    public boolean isCanMove() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentCanMove(v);
        return v.getValue() != 0;
    }
    
    public boolean isCanResize() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentCanResize(v);
        return v.getValue() != 0;
    }
    
    public boolean isCanRotate() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentCanRotate(v);
        return v.getValue() != 0;
    }
}
