package com.darryncampbell.enterprise.android.iot.client;

//  This class holds the default values for the connection settings for each of the supported
//  cloud providers.  You can edit many of these values from the corresponding UI
public class UserConfig {

    //  Default configuration for all projects
    public static String DEFAULT_DEVICE_ID = "test-device";

    //  Default configuration for Google Cloud Project
    public static final String GCP_PROJECT_ID = "ent-android-iot-server-gcp";
    public static final String GCP_REGISTRY_ID = "ent-android-iot-registry-gcp";
    public static final String GCP_PRIVATE_KEY_NAME = "rsa_private_pkcs8";
    public static final String GCP_ALGORITHM = "RS256";
    public static final String GCP_CLOUD_REGION = "europe-west1";

    //  Default configuration for Amazon Web Services
    public static final String AWS_CUSTOMER_SPECIFIC_ENDPOINT = "xxxxxxxxxxxxxx-ats.iot.us-west-2.amazonaws.com";
    public static final String AWS_COGNITO_POOL_ID = "us-west-2:xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx";
    public static final String AWS_IOT_POLICY_NAME = "ent-android-policy";
    public static final String AWS_CLOUD_REGION = "us-west-2";
    public static final String AWS_KEYSTORE_NAME = "iot_keystore";
    public static final String AWS_KEYSTORE_PASSWORD = "password";
    public static final String AWS_CERTIFICATE_ID = "default";
    public static final String AWS_TOPIC = "deviceTelemetry";

    //  Default configuration for Azure IoT
    //  Note: Connection string HARD CODES DEVICE ID so will be different for each device
    public static final String AZURE_CONNECTION_STRING = "HostName=xxxxxxxxx.azure-devices.net;DeviceId=xxxxxxx;SharedAccessKey=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final int AZURE_CRITICAL_BATTERY_LEVEL = 15;
}
