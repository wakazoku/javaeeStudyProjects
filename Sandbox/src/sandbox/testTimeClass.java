/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wak
 */
public class testTimeClass {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static void main(String[] args) throws ParseException {
        testTimeClass tst = new testTimeClass();
        tst.testString2toX();
        
        // TODO:Calender/utilDate型の日付計算
        // TODO:TimeAPIの使い方

    }

    private void testUtilDate() {
        // インスタンス化すると現在日時を取得
        Date utilDate = new Date();

        // Sun Mar 26 00:37:08 JST 2017
        System.out.println(utilDate);
    }

    private void testSqlDate() {
        // sql.Dateの場合は引数は1970-01-01からの経過時間をセット(long型)
        java.sql.Date sqlDate = new java.sql.Date(0);

        // 1970-01-01
        System.out.println(sqlDate);
    }

    private void testSimpleDateFormat() throws ParseException {
        // util.Date型で試す
        Date dt = sdf.parse("2017-03-22 10:15:76.091");

        // sql.Date型で試す
        java.sql.Date sqlDt = new java.sql.Date(sdf.parse("2017-03-22 10:15:76.032").getTime());

        // Timestamp型で試す
        Timestamp ts = new Timestamp(sdf.parse("2017-01-01 10:14:22.045").getTime());

        // Wed Mar 22 10:16:16 JST 2017 >多分これだと厳しい。ここから更に整形出来る？
        System.out.println(dt);

        // 2017-03-22 10:16:16.091 >util.Date型をsdfでfomratしてあげれば時分秒を持つStringが作れる
        System.out.println(sdf.format(dt.getTime()));

        // 2017-03-22 >Date型は時分秒がないことに注意。
        System.out.println(sqlDt);

        // 2017-01-01 10:14:22.045 >完璧な奴
        System.out.println(ts);

    }

    private void testString2toX() throws ParseException {
        // utilDateで指定のDate型を取得(sdf.parseでString型をutilDate型に変換出来る)
        Date dt = sdf.parse("2017-07-23 21:15:42.245");
        System.out.println(dt);

        // utilDateからsqlDateに変換したい時は一度Stringを噛ます
        String st = sdf.format(dt);
        System.out.println(st);

        // sqlDateで指定のsqlDate型を取得
        java.sql.Date sqDt = new java.sql.Date(sdf.parse(st).getTime());
        System.out.println(sqDt);

        // Timestamp型でもStringから変換
        Timestamp ts = new Timestamp(sdf.parse(st).getTime());
        System.out.println(ts);
    }

}
