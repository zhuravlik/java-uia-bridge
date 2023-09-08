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
package zhuravlik.automation.uom;

import com.sun.jna.platform.win32.User32;
import java.util.Iterator;
import org.jaxen.*;
import org.jaxen.saxpath.SAXPathException;
import zhuravlik.automation.util.win32.Win32Object;

public class Win32Navigator implements Navigator {

    public Iterator getChildAxisIterator(Object o) throws UnsupportedAxisException {
        return ((Win32Object)o).getChildItems().iterator();
    }

    public Iterator getDescendantAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getParentAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getAncestorAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getFollowingSiblingAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getPrecedingSiblingAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getFollowingAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getPrecedingAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getAttributeAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getNamespaceAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getSelfAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getDescendantOrSelfAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterator getAncestorOrSelfAxisIterator(Object o) throws UnsupportedAxisException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getDocument(String string) throws FunctionCallException {
        //throw new UnsupportedOperationException("Not supported yet.");
        return new Win32Object(null);
    }

    public Object getDocumentNode(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return new Win32Object(null);
    }

    public Object getParentNode(Object o) throws UnsupportedAxisException {
        //throw new UnsupportedOperationException("Not supported yet.");
        return ((Win32Object)o).getParent();
    }

    public String getElementNamespaceUri(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return "win32";
    }

    public String getElementName(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return ((Win32Object)o).getWndClass();
    }

    public String getElementQName(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getAttributeNamespaceUri(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getAttributeName(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getAttributeQName(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getProcessingInstructionTarget(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getProcessingInstructionData(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isDocument(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return o instanceof Win32Object;
    }

    public boolean isElement(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return o instanceof Win32Object;
    }

    public boolean isAttribute(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isNamespace(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isComment(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isText(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isProcessingInstruction(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getCommentStringValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getElementStringValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getAttributeStringValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNamespaceStringValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getTextStringValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNamespacePrefix(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String translateNamespacePrefixToUri(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public XPath parseXPath(String string) throws SAXPathException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getElementById(Object o, String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short getNodeType(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
