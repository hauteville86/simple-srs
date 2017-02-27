package pl.karolcyprowski.simple.srs.user;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements User {

	private String userId;
	
	public UserImpl()
	{
		initUserId();
	}
	
	public String getUserId()
	{
		if(userId == null)
		{
			initUserId();
		}
		return userId;
	}
	
	private void initUserId()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			if(authentication != null)
			{
				userId = authentication.getName();
			}
		}
	}
}
