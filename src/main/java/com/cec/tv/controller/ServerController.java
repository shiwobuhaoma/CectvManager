package com.cec.tv.controller;

import com.cec.tv.utils.LssUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServerController {

    private static int getServerStatus() {
        try {
            String[] cmds = {"/bin/sh", "-c", "ps -ef | grep \"/usr/local/nginx/sbin/nginx\" | wc -l"};
            Process p = Runtime.getRuntime().exec(cmds);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
            p.waitFor();
            int count = Integer.parseInt(br.readLine());
            if (count >= 3) {
                return 1;
            }
            return 0;
        } catch (Exception e) {

        }
        return -1;
    }


    private static boolean closeServer() {
        String[] cmds = {"/bin/sh", "-c", "ps -ax|grep nginx|grep -v grep|awk '{print $1}'|xargs kill -9"};
        int ev = LssUtil.CmdExec(cmds);
        return ev == 0;
    }

    private static boolean startServer() {
        String cmd = "/usr/local/nginx/sbin/nginx";
        int ev = LssUtil.CmdExec(cmd);
        return ev == 0;
    }
}
