package com.servercentral.communication.hub.email.impl;

import java.text.MessageFormat;

import com.github.jknack.handlebars.Options;

public class ConfigurationHelperSource {
   public static String getConfig(String config, final Options options) {
//      String value = ConfigurationUtil.config().getString(config);

//      if(options.params.length == 0) {
//         return value;
//      }
      MessageFormat format = new MessageFormat(config);
      return format.format(options.params);
   }
}
