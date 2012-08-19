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

package zhuravlik.automation.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure.ByReference;
import com.sun.jna.platform.win32.BaseTSD.LONG_PTR;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary, WinUser {

    public static final User32 INSTANCE = 
            (User32)Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);    

    public WinDef.HDC GetDC(WinDef.HWND hwnd);

    public int ReleaseDC(WinDef.HWND hwnd, WinDef.HDC hdc);

    public WinDef.HWND FindWindow(String string, String string1);

    public int GetClassName(WinDef.HWND hwnd, char[] chars, int i);

    public boolean GetGUIThreadInfo(int i, WinUser.GUITHREADINFO g);

    public boolean GetWindowInfo(WinDef.HWND hwnd, WinUser.WINDOWINFO wndwnf);

    public boolean GetWindowRect(WinDef.HWND hwnd, WinDef.RECT rect);

    public int GetWindowText(WinDef.HWND hwnd, char[] chars, int i);

    public int GetWindowTextLength(WinDef.HWND hwnd);

    public int GetWindowModuleFileName(WinDef.HWND hwnd, char[] chars, int i);

    public int GetWindowThreadProcessId(WinDef.HWND hwnd, IntByReference ibr);

    public boolean EnumWindows(WinUser.WNDENUMPROC w, Pointer pntr);

    public boolean EnumChildWindows(WinDef.HWND hwnd, WinUser.WNDENUMPROC w, Pointer pntr);

    public boolean EnumThreadWindows(int i, WinUser.WNDENUMPROC w, Pointer pntr);

    public boolean FlashWindowEx(WinUser.FLASHWINFO f);

    public WinDef.HICON LoadIcon(WinDef.HINSTANCE hnstnc, String string);

    public HANDLE LoadImage(WinDef.HINSTANCE hnstnc, String string, int i, int i1, int i2, int i3);

    public boolean DestroyIcon(WinDef.HICON hicon);

    public int GetWindowLong(WinDef.HWND hwnd, int i);

    public int SetWindowLong(WinDef.HWND hwnd, int i, int i1);

    public Pointer SetWindowLong(WinDef.HWND hwnd, int i, Pointer pntr);

    public LONG_PTR GetWindowLongPtr(WinDef.HWND hwnd, int i);

    public LONG_PTR SetWindowLongPtr(WinDef.HWND hwnd, int i, LONG_PTR lngptr);

    public Pointer SetWindowLongPtr(WinDef.HWND hwnd, int i, Pointer pntr);

    public boolean SetLayeredWindowAttributes(WinDef.HWND hwnd, int i, byte b, int i1);

    public boolean GetLayeredWindowAttributes(WinDef.HWND hwnd, IntByReference ibr, ByteByReference bbr, IntByReference ibr1);

    public boolean UpdateLayeredWindow(WinDef.HWND hwnd, WinDef.HDC hdc, WinUser.POINT point, WinUser.SIZE size, WinDef.HDC hdc1, WinUser.POINT point1, int i, WinUser.BLENDFUNCTION b, int i1);

    public int SetWindowRgn(WinDef.HWND hwnd, WinDef.HRGN hrgn, boolean bln);

    public boolean GetKeyboardState(byte[] bytes);

    public short GetAsyncKeyState(int i);

    public WinUser.HHOOK SetWindowsHookEx(int i, WinUser.HOOKPROC hkprc, WinDef.HINSTANCE hnstnc, int i1);

    public WinDef.LRESULT CallNextHookEx(WinUser.HHOOK hhook, int i, WinDef.WPARAM wparam, WinDef.LPARAM lparam);

    public WinDef.LRESULT CallNextHookEx(WinUser.HHOOK hhook, int i, WinDef.WPARAM wparam, Pointer pntr);

    public boolean UnhookWindowsHookEx(WinUser.HHOOK hhook);

    public int GetMessage(WinUser.MSG msg, WinDef.HWND hwnd, int i, int i1);

    public boolean PeekMessage(WinUser.MSG msg, WinDef.HWND hwnd, int i, int i1, int i2);

    public boolean TranslateMessage(WinUser.MSG msg);

    public WinDef.LRESULT DispatchMessage(WinUser.MSG msg);

    public void PostMessage(WinDef.HWND hwnd, int i, WinDef.WPARAM wparam, WinDef.LPARAM lparam);

    public void PostQuitMessage(int i);

    public int GetSystemMetrics(int i);

    public WinDef.HWND SetParent(WinDef.HWND hwnd, WinDef.HWND hwnd1);

    public boolean IsWindowVisible(WinDef.HWND hwnd);

    public boolean MoveWindow(WinDef.HWND hwnd, int i, int i1, int i2, int i3, boolean bln);

    public boolean SetWindowPos(WinDef.HWND hwnd, WinDef.HWND hwnd1, int i, int i1, int i2, int i3, int i4);

    public boolean AttachThreadInput(WinDef.DWORD dword, WinDef.DWORD dword1, boolean bln);

    public boolean SetForegroundWindow(WinDef.HWND hwnd);

    public WinDef.HWND GetForegroundWindow();

    public WinDef.HWND SetFocus(WinDef.HWND hwnd);

    public WinDef.DWORD SendInput(WinDef.DWORD dword, WinUser.INPUT[] inputs, int i);

    public WinDef.DWORD WaitForInputIdle(HANDLE handle, WinDef.DWORD dword);

    public boolean InvalidateRect(WinDef.HWND hwnd, ByReference br, boolean bln);

    public boolean RedrawWindow(WinDef.HWND hwnd, ByReference br, WinDef.HRGN hrgn, WinDef.DWORD dword);

    public WinDef.HWND GetWindow(WinDef.HWND hwnd, WinDef.DWORD dword);

    public boolean UpdateWindow(WinDef.HWND hwnd);

    public boolean ShowWindow(WinDef.HWND hwnd, int i);

    public boolean CloseWindow(WinDef.HWND hwnd);

    public boolean RegisterHotKey(WinDef.HWND hwnd, int i, int i1, int i2);

    public boolean UnregisterHotKey(Pointer pntr, int i);
    
    public WinDef.HWND GetParent(WinDef.HWND hwnd);

    public LRESULT SendMessage(HWND handle, int msg, WPARAM wparam, LPARAM lparam);
    //public LRESULT SendMessage(HWND handle, int msg, Pointer wparam, Pointer lparam);
    public LRESULT SendMessageA(HWND handle, int msg, int wparam, byte[] lparam);
}
