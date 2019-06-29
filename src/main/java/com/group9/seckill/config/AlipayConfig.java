package com.group9.seckill.config;

/* *
 *类名：AlipayConfig
 *作者：Rachel
 */

public class AlipayConfig {

    //应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100658200";

    //商户私钥，您的PKCS8格式RSA2私钥   私钥
    public static String private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCXAIr522osbpZ4LwNA1hAdR+xaJRpuMXI1GyvDF/Bif4cgNXTOPJfxQzMKzzQHDrRWbsRflInUJBWviWKPjAnAJE97JmBKrGIztYf9MD29u/7TSjX75Ca6Z/uFnXgXgC9zgzngZMnsujBpgJxZYFj/LPosFiUbjNrlEMX6aHD4RCdZcm2gyWlYdKvrJrQEn68sOvV6ejjuV3OwtaUkUPOetQMaAhx/XwdBo1B8UXoqWuCMaK8MFioqIrLlaPycXP0YHncHBEmQXthmPNgWdIiMa/DV868O5NWFO1g/2y0S+zWMwKBB7kYzEW2Ytw6kUezftAXUPTq3UWQZ+X7grwEXAgMBAAECggEAJmNf8XdDfbo7jKA/DnudKyR+xMgL+Rme9DtNG9L5LMFJA/ozEL88zXwM/OGCU4z8ccDFMZtcks79qFuf7+hlDjDs99zgu/spGAY9ZTOfbp3dga+rG7d71QXcXrKStj7DUXV6AD7/Sqxm5Ftq5BnnZi/0BcM3edKMT5G9ExT8K1EZc9MA1TtjELm0h8MmanUcttY90r0JmUyu3T/aF2BV3yVmwTQywLbyPTI8IvPO8QTYNgirkf6JZPRnzboxLTbJusRPtb4CKljfmn+T+w90ROI2+OpTQAL24HTAM4Nz82Ncm/ir9USXpcHySip8d9+TV/G38C39FpkRtJ5nLutzKQKBgQD5cGLqrgrZZTagHwcabifSFY6pWAF/5W2I71DjuVIIMWz4HPhSoz/vUHH5mT2laJgbsaKnmrS1Bav2E6NvxLRhrTWS5Q18HkwSlPE5d940FwjNFn69KjrHTMi711DNCdbP8rhApF5CXQay+NT+yoKNaKSpep+Wb6V+KOzyYyZGlQKBgQCa+VNK9CeUPD7+qxPnftgATnMRMaeQ8RfjIqT6GMUYs2dzcoGPpHFIZuIQqkH5d5DAaniQTlyYoOjrltC8znCl15Jsd6z1a6J8Az60mOkopahJDXoTB+S4wK52upC+nHGbb7J7pH/KZUCFnN/6VX/aw1T/bDllFtKw1C0Ue6ZZ+wKBgQCTw27lhNpqdBnK+vZzQsQWIK0VRkwFHr0nfFVXwYWF0vmxdT/pfEm4k9gguxWYsgBBj5ZCYVQhVE3NBU8xO757imcNMOEvIKeB7neDyq14ABk3nNbRan3NaIAVPnTgMa7uGuPpbzVjbMY2KU/L690wtcetmjWFoXfQ55+N6wxWjQKBgFD7FCFIsB3v1WMydnYzfB+83rgPYGaG9VqFUfw2UVf094wGO9mZrnCNAnh+33bCmetSN6oAqLZA7zWcW3stzQN8QFFZwBGGqyNudqfcd4n79pIl7rJfH4/Db+cu2lAgY+U7WuLtNLHIcwzeytN/Ng5Un+fQ37UJVhN87AmWC3ldAoGBAKU6lzbHz3IWALT8fFb7PqBxZF6qrnoQTRBReD5gepackJnnBb8V2Ph7dlEyGSVokzJJ9BaMisAj2Wi7kH35He3QzcUyb4cttY2VYKwhxgPA45ARhBEeuSJtMie/HIuan5NHWDJZp7jl4JuIlSxF9HgVAW4cpnKyDL9XZq6xWpdZ";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "/returnUrl";

    // 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //RSA2 支付宝公钥
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmOrCsZuCtd785WGbO9LeMLvcbW4fr5NCNGFKY9p/Mb5N063ErkSSn+t4UP6o3lV45fZIkdRoLz8nR2IL+oNC0tJI/XLzxQeuORSX31LSWEHRbzdYGq3kOQHs5gbO4kMArrrjIr/lIt4UNiHu8IALwjxVieJ7Gooj48oK5ONRJDywDckoY1lb6MIgk1IYL+yP9G4TYoMVUDUcNcqRZBYlveK1JcHevzjd/s++dS8fEEyJ0TAHveU0MtpKPaajTg2R2UxA1R1tZmOppsfTc+l0eMZkXQf4x7G0ML+v8KZh4IFASFQszKwdMRfT7lUpVSIDszPuiYccbdf/qF7OqqQXDQIDAQAB";

    public static String signtype = "RSA2";


}