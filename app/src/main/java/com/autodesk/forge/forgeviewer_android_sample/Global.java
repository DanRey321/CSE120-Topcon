package com.autodesk.forge.forgeviewer_android_sample;

import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.DerivativesApi;
import com.autodesk.client.api.ObjectsApi;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.auth.OAuth2TwoLegged;

/**
 *Daniel Reyes Adapted from xiaodongliang open source code
 * 4/28/2019
 */


public class Global {

    public static final String CLIENT_ID = "74RLCb1Krh6jnkuBlMIhiHxqTxXCAcRn";
    public static final String CLIENT_SECRET = "1cr2IqxqUOtQJCCm";

    public static String BUCKET_KEY = "";

    public static String FILE_NAME = "";

    public static String token = "";

    public static String URN = "";
    public static String base64URN = "";

    public static OAuth2TwoLegged oauth2TwoLegged = null;
    public static Credentials twoLeggedCredentials = null;

    public static final BucketsApi bucketsApi = new BucketsApi();
    public static final ObjectsApi objectsApi = new ObjectsApi();
    public static final DerivativesApi derivativesApi = new DerivativesApi();

}
