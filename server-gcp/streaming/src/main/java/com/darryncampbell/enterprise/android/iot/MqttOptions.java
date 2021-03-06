//  Based heavily on original file located at https://github.com/GoogleCloudPlatform/community/tree/master/tutorials/cloud-iot-rtdp/streaming/src/main/java/com/google/cloud/solutions/rtdp.  Full credit to original author

package com.darryncampbell.enterprise.android.iot;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/** Command line options for the MQTT example. */
public class MqttOptions {
  public String projectId;
  public String registryId;
  public String deviceId;
  public String privateKeyFile;
  public String algorithm;
  public String model;
  public String lat;
  public String lng;
  public int battLevel;
  public int battHealth;
  public String osVersion;
  public String patchLevel;
  public String releaseVersion;
  public String cloudRegion = "europe-west1";
  public int numMessages = 1;
  public String mqttBridgeHostname = "mqtt.googleapis.com";
  public short mqttBridgePort = 8883;

  /** Construct an MqttExampleOptions class from command line flags. */
  public static MqttOptions fromFlags(String[] args) {
    Options options = new Options();
    // Required arguments
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("project_id")
            .hasArg()
            .desc("GCP cloud project name.")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("registry_id")
            .hasArg()
            .desc("Cloud IoT registry id.")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("device_id")
            .hasArg()
            .desc("Cloud IoT device id.")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("private_key_file")
            .hasArg()
            .desc("Path to private key file.")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("algorithm")
            .hasArg()
            .desc("Encryption algorithm to use to generate the JWT. Either 'RS256' or 'ES256'.")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("model")
            .hasArg()
            .desc("Device Model")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("lat")
            .hasArg()
            .desc("Base lattitude")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("lng")
            .hasArg()
            .desc("Base longitude")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(Number.class)
            .longOpt("battLevel")
            .hasArg()
            .desc("Battery Level Percentage")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(Number.class)
            .longOpt("battHealth")
            .hasArg()
            .desc("Battery Health Percentage")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("osVersion")
            .hasArg()
            .desc("OS Version")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("patchLevel")
            .hasArg()
            .desc("OS Security Patch")
            .required()
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("releaseVersion")
            .hasArg()
            .desc("OS Release Version")
            .required()
            .build());

    // Optional arguments.
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("cloud_region")
            .hasArg()
            .desc("GCP cloud region.")
            .build());
    options.addOption(
        Option.builder()
            .type(Number.class)
            .longOpt("num_messages")
            .hasArg()
            .desc("Number of messages to publish.")
            .build());
    options.addOption(
        Option.builder()
            .type(String.class)
            .longOpt("mqtt_bridge_hostname")
            .hasArg()
            .desc("MQTT bridge hostname.")
            .build());
    options.addOption(
        Option.builder()
            .type(Number.class)
            .longOpt("mqtt_bridge_port")
            .hasArg()
            .desc("MQTT bridge port.")
            .build());

    CommandLineParser parser = new DefaultParser();
    CommandLine commandLine;
    try {
      commandLine = parser.parse(options, args);
      MqttOptions opts = new MqttOptions();

      opts.projectId = commandLine.getOptionValue("project_id");
      opts.registryId = commandLine.getOptionValue("registry_id");
      opts.deviceId = commandLine.getOptionValue("device_id");
      opts.privateKeyFile = commandLine.getOptionValue("private_key_file");
      opts.algorithm = commandLine.getOptionValue("algorithm");
      opts.model = commandLine.getOptionValue("model");
      opts.lat = commandLine.getOptionValue("lat");
      opts.lng = commandLine.getOptionValue("lng");
      
	  opts.battLevel = ((Number) commandLine.getParsedOptionValue("battLevel")).intValue();
      opts.battHealth = ((Number) commandLine.getParsedOptionValue("battHealth")).intValue();
      opts.osVersion = commandLine.getOptionValue("osVersion");
      opts.patchLevel = commandLine.getOptionValue("patchLevel");
      opts.releaseVersion = commandLine.getOptionValue("releaseVersion");
      if (commandLine.hasOption("cloud_region")) {
        opts.cloudRegion = commandLine.getOptionValue("cloud_region");
      }
      if (commandLine.hasOption("num_messages")) {
        opts.numMessages = ((Number) commandLine.getParsedOptionValue("num_messages")).intValue();
      }
      if (commandLine.hasOption("mqtt_bridge_hostname")) {
        opts.mqttBridgeHostname = commandLine.getOptionValue("mqtt_bridge_hostname");
      }
      if (commandLine.hasOption("mqtt_bridge_port")) {
        opts.mqttBridgePort =
            ((Number) commandLine.getParsedOptionValue("mqtt_bridge_port")).shortValue();
      }
      return opts;
    } catch (ParseException e) {
      System.err.println(e.getMessage());
      return null;
    }
  }
}
