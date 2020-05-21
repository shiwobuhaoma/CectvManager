package com.cec.tv.utils;




import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;

public class LssUtil {
    /**
     * @param cmdline /usr/local/nginx/sbin/nginx
     * @return
     */
    public static int CmdExec(String cmdline) {
        System.out.println("cmd===" + cmdline);
        try {
            Process p = null;
            if (p != null) {
                p.destroy();
                p = null;
            }
            p = Runtime.getRuntime().exec(cmdline);
            p.waitFor();
            int ret = p.exitValue();
            System.out.println(cmdline + " 执行结果：" + ret);
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
        }
        return -1;
    }

    public static int CmdExec(String[] cmdline) {
        try {
            Process p = null;
            if (p != null) {
                p.destroy();
                p = null;
            }
            p = Runtime.getRuntime().exec(cmdline);
            p.waitFor();
            int ret = p.exitValue();
            System.out.println(cmdline + " 执行结果：" + ret);
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
        }
        return -1;
    }

    public static int CmdExec1(String[] cmdline) {
        try {
            Process p = null;
            if (p != null) {
                p.destroy();
                p = null;
            }
            p = Runtime.getRuntime().exec(cmdline);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
            p.waitFor();
            return Integer.parseInt(br.readLine().toString());
        } catch (Exception err) {
        }
        return -1;
    }

    public static String refreshFileList(String strPath, String type, String fname) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        List filelist = new ArrayList();
        if (files == null)
            return "";
        String json = "[";
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                json = json + "{\"cls\":\"icon-file\",\"id\":\"" + files[i].getAbsolutePath() + "\",\"leaf\":false,\"text\":\"" + files[i].getName() + "\"},";
            } else {
                Map fMap = new HashMap();
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                System.out.println("文件-fdsaf--" + fname);
                if (files[i].getName().equals(fname)) {
                    System.out.println("files[i].getName()---" + files[i].getName());
                    fMap.put("fileName", files[i].getName());
                    fMap.put("fileType", files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1));
                    fMap.put("size", Long.valueOf(files[i].length()));
                    fMap.put("filePath", strFileName);
                    filelist = new ArrayList();
                    filelist.add(fMap);
                    break;
                }
                fMap.put("fileName", files[i].getName());
                fMap.put("fileType", files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1));
                fMap.put("size", Long.valueOf(files[i].length()));
                fMap.put("filePath", strFileName);
                filelist.add(fMap);
            }
        }
        if (!filelist.isEmpty()) {
            Collections.sort(filelist, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Map<String, Object> oo1 = (Map<String, Object>) o1;
                    Map<String, Object> oo2 = (Map<String, Object>) o2;
                    String b1 = (String) oo1.get("fileName");
                    String b2 = (String) oo2.get("fileName");
                    if (b2 != null) {
                        return b1.compareTo(b2);
                    }
                    return 0;
                }

            });
        }

        if (!json.equals("[")) {
            json = json.substring(0, json.length() - 1);
        }
        json = json + "]";
        if ("file".equals(type)) {
//            ListRange lr = new ListRange();
//            lr.setRows(filelist);
//            lr.setTotal(filelist.size());
//            try {
//                json = JSONObject.fromObject(lr).toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

        }

        return json;
    }

    public static int getPid(Process p) {
        try {
            Field pidField = p.getClass().getDeclaredField("pid");
            pidField.setAccessible(true);
            int pid = ((Integer) pidField.get(p)).intValue();
            System.err.println("pid = " + pid);
            return pid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
