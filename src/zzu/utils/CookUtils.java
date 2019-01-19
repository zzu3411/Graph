package zzu.utils;



import javax.servlet.http.Cookie;

public class CookUtils {
	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * @param name cookie名称
	 * @param cookies  cookie数组
	 * @return
	 */
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())){
					//返回
					return c;
				}
			}
		}
		return null;
	}

	public static Cookie getCookie(Cookie[] allCookie , String cookieName){
		if(cookieName == null){
			return null;
		}
		if(allCookie != null){
			for (Cookie c:allCookie){
				if(cookieName.equals(c.getName())){
					return c;
				}
			}
		}
		return null;
	}
}
