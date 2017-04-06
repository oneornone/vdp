package com.dmio.org.tut.core.utils;

import android.content.res.AssetManager;

import com.dmio.org.tut.application.ExApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Assert Utils
 *
 * @author wangmeng noneorone@yeah.net
 * @since 2017/2/23 20:09
 */
public class AssertUtils {

    /**
     * 获取json文件中的数据
     *
     * @param jsonFileName json文件名称
     * @return
     */
    public static final String getJsonData(String jsonFileName) {
        InputStream is = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        StringBuilder content = new StringBuilder();
        try {
            AssetManager assets = ExApplication.getInstance().getAssets();
            is = assets.open(jsonFileName);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                } finally {
                    br = null;
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                } finally {
                    isr = null;
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                } finally {
                    is = null;
                }
            }
        }

        return content.toString();
    }

}
