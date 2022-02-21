UserDetails предоставляет необходимую информацию для построения объекта 
Authentication из DAO объектов приложения или других источников данных системы безопасности.
Объект UserDetailsсодержит имя пользователя, пароль,
	флаги: isAccountNonExpired,
	isAccountNonLocked,
	isCredentialsNonExpired,
	isEnabled
	и Collection — прав (ролей) пользователя.


* GrantedAuthority отражает разрешения выданные доверителю в масштабе всего приложения. UserDetails предоставляет необходимую информацию для построения объекта Authentication из DAO объектов приложения или других источника данных системы безопасности.