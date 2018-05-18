package bsuir;
/*
    Created by Gleb Remniov and Christina Kovalevich.
    Cooperate: remniov.work@gmail.com
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException { // Указываем, что данный метод может выбрасывать IOException
        DatagramSocket datagramSocket = new DatagramSocket(1409); // Создание сокета дейтаграмм с указанием порта 1409
        DatagramPacket datagramPacket; // Объявление поката дейтаграмм
        InetAddress inetAddress = InetAddress.getByName("localhost");
        byte[] bytes = new byte[100];
        new Scanner(System.in);
        char array[] = {'x', 'y', 'z'};// Массив для отбражения имен переменных, значения которых нужно ввести пользователю
        for (char i : array) { // Улучшеный цикл for-each
            System.out.print("Enter " + i + ": ");
            int length = System.in.read(bytes); // Считываем с клавиатуры данные для переменной
            datagramPacket = new DatagramPacket(bytes, length, inetAddress, 1408);
            datagramSocket.send(datagramPacket);
        }
        datagramPacket = new DatagramPacket(bytes, 100);
        datagramSocket.receive(datagramPacket);// Получение пакета от сервера
        System.out.println("The answer is " + new String(datagramPacket.getData()));
        datagramSocket.close();// Закрытие сокета дейтаграм
    }
}

