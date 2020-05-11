package com.example.qrcode.service;

public interface ICodeService<T> {
    byte[] genQRcode(T message);
}
