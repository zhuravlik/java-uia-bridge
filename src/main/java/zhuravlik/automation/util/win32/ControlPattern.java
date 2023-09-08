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

/**
 *
 * @author Администратор
 */
public enum ControlPattern {

    Annotation(10023),
    Dock(10011),
    Drag(10030),
    DropTarget(10031),
    ExpandCollapse(10005),
    GridItem(10007),
    Grid(10006),
    Invoke(10000),
    ItemContainer(10019),
    LegacyIAccessible(10018),
    MultipleView(10008),
    ObjectModel(10022),
    RangeValue(10003),
    ScrollItem(10017),
    Scroll(10004),
    SelectionItem(10010),
    Selection(10001),
    Spreadsheet(10026),
    SpreadsheetItem(10027),
    Styles(10025),
    SynchronizedInput(10021),
    TableItem(10013),
    Table(10012),
    TextChild(10029),
    Text(10014),
    Text2(10024),
    Toggle(10015),
    Transform(10016),
    Transform2(10028),
    Value(10002),
    VirtualizedItem(10020),
    Window(10009);
    private int value;

    private ControlPattern(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
