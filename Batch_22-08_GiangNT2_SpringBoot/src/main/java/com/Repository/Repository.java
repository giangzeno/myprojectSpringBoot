package com.Repository;

/** 
 * Repository
 * 
 * Version 0.0.1-SNAPSHOT
 * 
 * Date: 16-02-2023
 * 
 * Copyright 
 * 
 * Modification Logs:
 * 
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 20/02/2023            GiangNT2            Create
 *  
 * */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.Movie;
import com.Entity.Schedule;
import com.Entity.Type;

@Transactional
@Controller
public class Repository {
	public static final String LISTSCHEDULE = "select * from Schedule where Schedule_Time =:value";
	public static final String LISTSCHEDULE_TIME = "select Schedule_Time from Schedule group by Schedule_Time";
	public static final String LISTTYPE = "select * from Type where Type_Name = :value";
	public static final String LISTTYPE_NAME = "select Type_Name from Type group by Type_Name";
	public static final String VALIDATE_MOVIE_ID = "select * from Movie where Movie_ID = :Movie_ID";
	public static final String GETLISTMOVIE = "select * from Movie where Version =:var or Movie_Name_ENG =:var ";
	public static final String GETLISTMOVIE_NOTDATE = "select * from Movie where Version =:var or From_Date =:var or Movie_Name_ENG =:var ";
	public static final String DELETEMOVIE = "select * from Movie where Movie_ID = :movie_ID";
	public static final String DETAIL = "select * from Movie where Movie_ID = :movie_ID";
	public static final String MOVIE_TYPE = "select Type_Name from Type join Movie_Type on Movie_Type.Type_ID = Type.Type_ID join\r\n"
			+ "Movie  on Movie.Movie_ID = Movie_Type.Movie_ID where Movie.Movie_ID =:movie_ID group by Type_Name";
	public static final String MOVIE_SCHEDULE = "select  Schedule_Time from Schedule join Movie_Schedule on Schedule.Schedule_ID = Movie_Schedule.Schedule_ID join\r\n"
			+ "Movie  on Movie.Movie_ID = Movie_Schedule.Movie_ID where Movie.Movie_ID = :movie_ID group by Schedule_Time";
	public static final String GETALLMOVIE = "select * from Movie";

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Add Object vào Database
	 * 
	 * @param Movie movie
	 * @return Boolean
	 */
	public Boolean add(Movie movie) {
		Session ss = sessionFactory.openSession();
		Transaction tran = ss.beginTransaction();
		try {
			ss.save(movie);
			tran.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Get List Schedule theo List String Schedule time
	 * 
	 * @param List<String>
	 * @return List<Schedule>
	 */
	public Set<Schedule> listSchedule(List<String> list) {
		Set<Schedule> scheduleList = new HashSet<Schedule>();
		Session ss = sessionFactory.openSession();
		List<Schedule> listSchedule = null;
		try {
			for (String var : list) {
				NativeQuery<Schedule> objs = ss.createNativeQuery(LISTSCHEDULE, Schedule.class);
				objs.setParameter("value", var);
				listSchedule = new ArrayList<Schedule>();
				listSchedule = objs.list();
				if (listSchedule.size() > 0) {
					scheduleList.add(listSchedule.get(0));
				}
			}
			return scheduleList;

		} catch (Exception e) {
			return scheduleList;
		}
	}

	/**
	 * Get List Type theo List Type Name
	 * 
	 * @param List<String>
	 * @return List<Type>
	 */
	public Set<Type> listType(List<String> list) {
		Set<Type> scheduleList = new HashSet<Type>();
		Session ss = sessionFactory.openSession();
		List<Type> listType = null;
		try {
			
			for (String var : list) {
				NativeQuery<Type> objs = ss.createNativeQuery(LISTTYPE, Type.class);
				objs.setParameter("value", var);
				listType = new ArrayList<Type>();
				listType = objs.list();
				if (listType.size() > 0) {
					scheduleList.add(listType.get(0));
				}
			}
			return scheduleList;

		} catch (Exception e) {
			return scheduleList;
		}
	}

	/**
	 * Get all List Type Name
	 * 
	 * @return List<String>
	 */
	public List<String> listType() {
		List<String> type = new ArrayList<>();
		Session ss = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			NativeQuery<String> objs = ss.createNativeQuery(LISTTYPE_NAME);
			type = objs.getResultList();
			return type;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Get all List Schedule time
	 * 
	 * @return List<String>
	 */
	public List<String> listSchedule() {
		List<String> scheduleList = new ArrayList<>();
		Session ss = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			NativeQuery<String> objs = ss.createNativeQuery(LISTSCHEDULE_TIME);
			scheduleList = objs.getResultList();
			return scheduleList;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Kiểm tra Movie_Id đã tồn tại hay chưa
	 * 
	 * @param String Movie_Id
	 * @return Boolean
	 */
	public boolean validateID(String id) {
		Session ss = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			NativeQuery<Movie> objs = ss.createNativeQuery(VALIDATE_MOVIE_ID);
			objs.setParameter("Movie_ID", id);
			return objs.list().size() > 0;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * Tìm kiếm toàn bộ Movie theo giá trị search
	 * 
	 * @param String search
	 * @return List<Movie>
	 */
	public List<Movie> getListMovie(String search) {
		Session ss = sessionFactory.openSession();

		try {
			NativeQuery<Movie> query = ss.createNativeQuery(GETLISTMOVIE, Movie.class);
			query.setParameter("var", search);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Tìm kiếm toàn bộ Movie theo giá trị search
	 * 
	 * @param String search
	 * @return List<Movie>
	 */
	public List<Movie> getListMovieNoDate(String search) {
		Session ss = sessionFactory.openSession();
		try {
			NativeQuery<Movie> query = ss.createNativeQuery(GETLISTMOVIE_NOTDATE, Movie.class);
			query.setParameter("var", search);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Delete Movie theo Movie_ID
	 * 
	 * @param Movie_ID
	 * @return Bolean
	 */
	public boolean deleteMovie(String movie_ID) {
		Session ss = sessionFactory.openSession();
		Transaction transaction = ss.beginTransaction();
		try {

			NativeQuery<Movie> movie = ss.createNativeQuery(DELETEMOVIE, Movie.class);
			movie.setParameter("movie_ID", movie_ID);
			Movie obj = movie.getSingleResult();
			if (obj == null) {

				System.out.println(false);
				return false;
			} else {

				ss.delete(obj);
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * Get Movie theo Movie_Id
	 * 
	 * @param String Movie_ID
	 * @return Object Movie
	 */
	public Movie Detail(String movie_ID) {
		Session ss = sessionFactory.openSession();
		try {

			NativeQuery<Movie> movie = ss.createNativeQuery(DETAIL, Movie.class);
			movie.setParameter("movie_ID", movie_ID);
			Movie obj = (Movie) movie.getSingleResult();
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Get list Type_name theo Movie_id
	 * 
	 * @param String Movie_id
	 * @return String[] Type_name
	 */
	public String[] Movie_Type(String movie_ID) {
		List<String> type = new ArrayList<>();

		Session ss = sessionFactory.openSession();
		try {

			@SuppressWarnings("unchecked")
			NativeQuery<String> movie = ss.createNativeQuery(MOVIE_TYPE);
			movie.setParameter("movie_ID", movie_ID);
			type = movie.getResultList();
			String[] Type_name = type.toArray(new String[0]);
			return Type_name;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Get list Schedule_time theo Movie_id
	 * 
	 * @param String Movie_ID
	 * @return String[] Schedule_time
	 */
	public String[] Movie_Schedule(String movie_ID) {
		List<String> scheduleList = new ArrayList<>();
		Session ss = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			NativeQuery<String> movie = ss.createNativeQuery(MOVIE_SCHEDULE);
			movie.setParameter("movie_ID", movie_ID);
			scheduleList = movie.getResultList();
			String[] Schedule_Time = scheduleList.toArray(new String[0]);
			return Schedule_Time;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Get toàn bộ List Movie
	 * 
	 * @return Full List<Movie>
	 */
	public List<Movie> getAllMovie() {
		Session ss = sessionFactory.openSession();
		try {
			NativeQuery<Movie> list = ss.createNativeQuery(GETALLMOVIE, Movie.class);
			return list.list();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void Sampledata() {
		Session ss = sessionFactory.getCurrentSession();
		String sql = "insert into Schedule values ('08:00')\r\n"
				+ "insert into Schedule values ('09:00')\r\n"
				+ "insert into Schedule values ('10:00')\r\n"
				+ "insert into Schedule values ('13:30')\r\n"
				+ "insert into Schedule values ('14:30')\r\n"
				+ "insert into Schedule values ('15:00')\r\n"
				+ "insert into Schedule values ('17:00')\r\n"
				+ "insert into Schedule values ('18:30')\r\n"
				+ "insert into Schedule values ('19:00')\r\n"
				+ "insert into Schedule values ('20:00')\r\n"
				+ "insert into Schedule values ('21:00')\r\n"
				+ "insert into Schedule values ('21:30')\r\n"
				+ "insert into Schedule values ('20:30')\r\n"
				+ "insert into Schedule values ('22:00')\r\n"
				+ "insert into Schedule values ('22:15')"
				+ "insert into Type values ('Hành động')\r\n"
				+ "insert into Type values ('Phiêu lưu')\r\n"
				+ "insert into Type values ('Phim hài')\r\n"
				+ "insert into Type values ('Hoạt hình')\r\n"
				+ "insert into Type values ('Hình sự')\r\n"
				+ "insert into Type values ('Tâm lý')\r\n"
				+ "insert into Type values ('Tình cảm')\r\n"
				+ "insert into Type values ('Lịch sử')\r\n"
				+ "insert into Type values ('Cổ trang')\r\n"
				+ "insert into Type values ('Kinh dị')\r\n"
				+ "insert into Type values ('Chiến Tranh')\r\n"
				+ "insert into Type values ('Tâm Lí 18+')\r\n"
				+ "insert into Type values ('Kiếm Hiệp')\r\n"
				+ "insert into Type values ('Ca nhạc')";
		ss.createNativeQuery(sql).executeUpdate();
	}
}
