package cn.studybigdata.java.py4j;

import py4j.GatewayServer;

/**
 * 	DEFAULT_PORT = 25333;
 *  DEFAULT_PYTHON_PORT = 25334;
 */
public class AdditionApplication {

    public int addition(int first, int second) {
        System.out.println("Java端接收到数字："+first+"---"+second);
        return first + second;
    }

    public static void main(String[] args) {
        AdditionApplication app = new AdditionApplication();
        // app is now the gateway.entry_point
        GatewayServer server = new GatewayServer(app);
        server.start();
    }
}