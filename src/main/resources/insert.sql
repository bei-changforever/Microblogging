INSERT INTO public.user_account(
    user_id, password, username, email, role, enabled)
VALUES (?, ?, ?, ?, ?, ?);



//-------------------------------------------------------------------------------
INSERT INTO public.comment(
	commenter, comment_info, comment_time,user_id)
	VALUES ('a', 'aaaaaa', '2021-12-11',13);
INSERT INTO public.comment(
    commenter, comment_info, comment_time,user_id)
VALUES ('b', 'bbbbbb', '2021-12-11',13);
INSERT INTO public.comment(
    commenter, comment_info, comment_time,user_id)
VALUES ('c', 'cccccc', '2021-12-11',13);