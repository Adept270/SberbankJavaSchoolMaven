package com.jschool.Day7_Classloaders.PluginLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL[] urls = new URL[]{new URL(pluginRootDirectory + File.pathSeparator + pluginName + File.pathSeparator)};
        PluginClassLoader pluginClassLoader = new PluginClassLoader(urls);

        return (Plugin) pluginClassLoader.loadClass(pluginClassName).newInstance();
    }
}
