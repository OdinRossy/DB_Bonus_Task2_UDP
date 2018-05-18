package bsuir;
//Импортируем необходимые классы
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;

public  class Server {

    private static DatagramSocket datagramSocket; // объявление сокета дейтаграмм, объявлен как глобальная переменная
                                                // для удобства, т.к он будет ипользоваться в двух разных функциях
    public static void main(String[] args) throws IOException {
        byte [] bytes = new byte[100];
        final int x, y, z; //Переменные, в которые будут записаны значения, пришедшие от клиента
        DatagramPacket datagramPacket = new DatagramPacket(bytes,100);
        datagramSocket = new DatagramSocket(1408); // Непосредсвенное выделение памяти и создание для сокета дейтаграм
        System.out.println("Waiting for a connection..");
        datagramSocket.receive(datagramPacket);
        String str = new String(datagramPacket.getData()); //строка составленная из массива передаваемых в пакете байтов
        str = str.substring(0, str.indexOf('\n')); // Переопределяем существующую строку подстрокой по символу переноса строки
        System.out.println("x: " + str);
        x = Integer.parseInt(str); // Парсим строку в тип данных int с помощью статического метода класса Integer
        // Далее происходит все то же самое, но уже для перемнных x и y
        datagramSocket.receive(datagramPacket);
        str = new String(datagramPacket.getData());
        str = str.substring(0, str.indexOf('\n'));
        System.out.println("y: " + str);
        y = Integer.parseInt(str);
        datagramSocket.receive(datagramPacket);
        str = new String(datagramPacket.getData());
        str = str.substring(0, str.indexOf('\n'));
        System.out.println("z: " + str);
        z = Integer.parseInt(str);
        sendBack(datagramPacket, allMagicIsHere(x, y, z)); //Вызываем функцию sendBack(34 строка) и
        // передаем в нее объект datagramPacket, а так же вызываем функцию allMagicIsHere(44 строка),
        // результат которой есть некоторое значение типа даннх double. В функцию allMagicIsHere передаем
        // в параметры значения переменных, уже переведенных в int
    }

    private static void sendBack(DatagramPacket datagramPacket, double result) throws IOException { //Функция для отправки ответа клиенту
        String string = String.valueOf(result);
        System.out.println("Sending back to client " + string);
        byte [] bytes = string.getBytes();
        datagramPacket = new DatagramPacket(bytes, bytes.length, datagramPacket.getAddress(), datagramPacket.getPort() );
        datagramSocket.send(datagramPacket); // Отправляем пакет обратно клиенту
        datagramSocket.close(); // Закрываем сокет дейтаграмм
    }
    private static double allMagicIsHere(int x, int y, int z){ //Функция для математических расчетов в результате которой будет значение типа double
        double res1 = z/3;
        double res2 = Math.tan(res1); //tg
        double res3 = Math.pow(res2, 2.0); // Возведение в степень
        double res4 = 1 + res3;
        double res5 = Math.abs(y); // Модуль
        double res6 = res5 + 7;
        double res7 = Math.sqrt(res6); // Квадратный корень
        double res8 = Math.pow(res4, res7);
        double res9 = Math.pow(x, 3.0);
        double res10 = res9/y;
        double res11 = y + res10;
        double res12 = Math.pow(x, 2.0);
        double res13 = res12/res11;
        double res14 = y + res13;
        double res15 = x-y;
        double res16 = Math.exp(res15); //e^x-y
        double res17 = res16/res14;
        double res18 = res17 * res8;
        double res19 = y + res18;
        saveInFile(x, y, z, res19); // Вызываем функцию saveInFile для сохранения значений в файл
                                    //и передаем все необходимые данные
        return res19; //Результатом работы функции будет некоторое значение типа данных double
    }
    private static void saveInFile(int x, int y, int z, double result){ //Функция для записи в файл исходных параметров и ответа
        String string = "Значение x: " + x + "\n" +
                        "Значение y: " + y + "\n" +
                        "Значение z: " + z + "\n" +
                        "Ответ: " + result + ".";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("History.txt", true); //append=true - Для возможности дописывать даные файл без потери содержимого
            fileWriter.write(string + "\n\n");//Зываем в файл. Для удобства записи будут отделяться двумя переносами строки
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}