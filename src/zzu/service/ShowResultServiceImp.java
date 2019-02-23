package zzu.service;

import zzu.dao.ShowResultDao;
import zzu.dao.ShowResultDaoImp;
import zzu.domin.StudentTime;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ShowResultServiceImp implements ShowResultService {
    @Override
    public double findSingleDuration(Integer studentID, Integer curriculumID) throws ParseException, SQLException {
        ShowResultDao showResultDao = new ShowResultDaoImp();
        List<StudentTime> res = showResultDao.findSingleDuration(studentID ,curriculumID);
        Date startDate = null;
        Date endDate = null;
        double miao = 0, fen = 0, hour = 0, totalHour = 0;
        for (StudentTime s:res) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startDate= formatter.parse(s.getStartTime());
            endDate = formatter.parse(s.getEndTime());
            miao=(endDate.getTime()-startDate.getTime())/1000;//除以1000是为了转换成秒
            hour=(miao/60)/60;  //  多少小时
            totalHour = totalHour + hour;
        }
        System.out.println("单科总时长" + totalHour);
        return totalHour;

    }

    @Override
    public double findTotalDuration(Integer studentID) throws SQLException, ParseException {
        ShowResultDao showResultDao = new ShowResultDaoImp();
        List<StudentTime> res = showResultDao.findTotalDuration(studentID);
        Date startDate = null;
        Date endDate = null;
        double miao = 0, fen = 0, hour = 0, totalHour = 0;
        for (StudentTime s:res) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startDate= formatter.parse(s.getStartTime());
            endDate = formatter.parse(s.getEndTime());
            miao=(endDate.getTime()-startDate.getTime())/1000;//除以1000是为了转换成秒
            fen= miao/60;   // 多少分
            hour=(miao/60)/60;  //  多少小时
            totalHour = totalHour + hour;
        }
        System.out.println("总时长" + totalHour);
        return totalHour;
    }
}
