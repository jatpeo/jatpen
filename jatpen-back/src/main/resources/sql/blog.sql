create table article
(
  id int auto_increment comment '主键' primary key,
  title varchar(50) not null comment '文章标题',
  description text null comment '文章描述',
  author varchar(50) null comment '文章作者',
  content longtext null comment '文章内容',
  content_format longtext null comment 'html的content',
  read_num int default '0' null comment '阅读量',
  comment_num int default '0' null comment '评论量',
  like_num int default '0' null comment '点赞量',
  cover_type int null comment '文章展示类别,1:普通，2：大图片，3：无图片',
  cover text null comment '封面',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '更新时间',
  recommend tinyint(1) default '0' not null comment '是否推荐文章',
  category_id varchar(50) null comment '分类类别存在多级分类，用逗号隔开',
  publish tinyint default '0' null comment '发布状态',
  top tinyint(1) default '0' null comment '是否置顶'
) comment '文章';

INSERT INTO article (id, title, description, author, content, content_format, read_num, comment_num, like_num, cover_type, cover, create_time, update_time, recommend, category_id, publish, top) VALUES (1, '关于本站和博主', '关于本站和博主', '***', '# 关于我
***，英文名***，是一名努力成长中的Java爱好者

# 关于本站
本站前端Vue，后台是Java
', '<h1 id="-">关于我</h1>
<p>***，英文名***，是一名努力成长中的Java爱好者
</p>
<h1 id="-">关于本站</h1>
<p>本站前端Vue，后台是Java
', 0, 0, 0, 1, 'http://oss.dblearn.cn/r_blog/20190303/18a6c1d2ed47494396462901ffe02f30.jpg', now(), now(), 1, '1,2,3', 1, 1);

create table book
(
  id int auto_increment comment '主键' primary key,
  title varchar(100) null comment '标题',
  cover varchar(255) null comment '封面',
  author varchar(50) null comment '作者',
  category_id varchar(20) null comment '分类类别',
  recommend tinyint(1) default '0' null comment '是否推荐',
  publisher varchar(100) null comment '出版社',
  publish_date date null comment '出版日期',
  page_num int null comment '页数',
  grade double null comment '评分',
  description text null comment '简介',
  catalogue text null comment '原书目录',
  create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  update_time datetime default CURRENT_TIMESTAMP null comment '更新时间',
  read_num int default '0' null comment '阅读量',
  comment_num int default '0' null comment '评论量',
  like_num int default '0' null comment '点赞量',
  publish tinyint(1) default '0' null comment '是否发布',
  progress int default '0' null comment '读书状态',
  reading tinyint(1) null comment '是否阅读'
) comment '图书表';

create table book_note
(
  id int auto_increment comment '主键' primary key,
  title varchar(50) not null comment '笔记标题',
  description text null comment '笔记描述',
  author varchar(50) null comment '笔记作者',
  content longtext null comment '笔记内容',
  content_format longtext null comment 'html的context',
  read_num int default '0' null comment '阅读量',
  comment_num int default '0' null comment '评论量',
  like_num int default '0' null comment '点赞量',
  cover text null comment '封面',
  book_id int null comment '所属书本',
  chapter varchar(255) null comment '所属章节',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '更新时间',
  recommend tinyint(1) default '0' not null comment '是否推荐笔记',
  category_id varchar(50) null comment '分类类别存在多级分类，用逗号隔开',
  publish tinyint default '0' null comment '发布状态',
  cover_type int null comment '封面类型',
  top tinyint(1) null comment '是否置顶'
) comment '笔记';

create table book_sense
(
  id int auto_increment comment '主键' primary key,
  author varchar(20) null comment '作者',
  content text null comment '内容',
  book_id int null comment '关联图书Id',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '更新时间'
) comment '读后感';

create table category
(
  id int auto_increment comment '主键',
  name varchar(255) null comment '名称',
  type int null comment '类型：0文章，1阅读',
  `rank` int null comment '级别',
  parent_id int default '0' null comment '父主键',
  constraint operation_category_id_uindex
  unique (id)
);

alter table category add primary key (id);

INSERT INTO category (id, name, type, `rank`, parent_id) VALUES (1, '漫谈', 0, 0, -1);
INSERT INTO category (id, name, type, `rank`, parent_id) VALUES (2, '本站相关', 0, 1, 1);
INSERT INTO category (id, name, type, `rank`, parent_id) VALUES (3, '关于', 0, 2, 2);

create table link
(
  id int auto_increment comment '主键' primary key,
  title varchar(50) null comment '链接名称',
  url varchar(500) null comment '链接地址',
  avatar varchar(255) null comment '头像'
) comment '友链';

create table log_like
(
  id bigint auto_increment primary key,
  type varchar(50) null comment '点赞类型',
  params varchar(5000) null comment '请求参数',
  time bigint not null comment '执行时长(毫秒)',
  ip varchar(64) null comment 'IP地址',
  create_date datetime null comment '创建时间'
) comment '点赞日志';

create table log_view
(
  id bigint auto_increment primary key,
  type varchar(50) null comment '浏览类型',
  method varchar(200) null comment '请求方法',
  params varchar(5000) null comment '请求参数',
  time bigint not null comment '执行时长(毫秒)',
  ip varchar(64) null comment 'IP地址',
  create_date datetime null comment '创建时间'
) comment '阅读日志';

create table oss_resource
(
  id int auto_increment comment '主键' primary key,
  name varchar(255) null comment '名称',
  url varchar(255) null
) comment '云存储资源表';

create table recommend
(
  id int auto_increment comment '主键' primary key,
  link_id int null comment '推荐的文章Id',
  type int null comment '推荐类型',
  order_num int default '0' null comment '顺序',
  title varchar(100) null comment '标题',
  top tinyint(1) default '0' null comment '置顶'
) comment '推荐';

create table sys_menu
(
  menu_id bigint auto_increment primary key,
  parent_id bigint null,
  name tinytext null,
  url varchar(200) null,
  perms varchar(500) null,
  type int null,
  icon tinytext null,
  order_num int null
) comment '菜单管理';

INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (1, 0, '系统管理', null, null, 0, 'config', 3);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (2, 1, '管理员列表', 'sys/user', null, 1, 'admin', 1);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (3, 1, '角色管理', 'sys/role', null, 1, 'role', 2);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (4, 1, '菜单管理', 'sys/menu', null, 1, 'menu', 3);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (5, 1, 'SQL监控', 'http://localhost:8080/r_blog/druid/sql.html', null, 1, 'config', 5);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (15, 2, '查看', null, 'sys:user:list,sys:user:info', 2, null, 0);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (16, 2, '新增', null, 'sys:user:save,sys:role:select', 2, null, 0);
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (17, 2, '修改', null, 'sys:user:update,sys:role:select', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (18, 2, '删除', null, 'sys:user:delete', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (19, 3, '查看', null, 'sys:role:list,sys:role:info', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (20, 3, '新增', null, 'sys:role:save,sys:menu:list', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (21, 3, '修改', null, 'sys:role:update,sys:menu:list', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (22, 3, '删除', null, 'sys:role:delete', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (23, 4, '查看', null, 'sys:menu:list,sys:menu:info', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (24, 4, '新增', null, 'sys:menu:save,sys:menu:select', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (25, 4, '修改', null, 'sys:menu:update,sys:menu:select', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (26, 4, '删除', null, 'sys:menu:delete', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (30, 0, '博文管理', null, null, 0, 'article', 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (31, 30, '新增博文', 'article/article-add-or-update', 'article:save,article:update', 1, 'add', 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (32, 30, '博文列表', 'article/article', null, 1, 'list', 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (33, 32, '删除', null, 'article:delete', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (34, 32, '查看', null, 'article:list', 2, null, 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (38, 43, '分类管理', 'operation/category', null, 1, 'category', 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (39, 38, '查看', null, 'operation:category:list,operation:category:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (40, 38, '新增', null, 'operation:category:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (41, 38, '修改', null, 'operation:category:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (42, 38, '删除', null, 'operation:category:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (43, 0, '运营管理', null, null, 0, 'operation', 2);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (45, 1, '系统参数', 'sys/param', null, 1, 'param', 4);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (46, 45, '查看', null, 'sys:param:list,sys:param:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (47, 45, '新增', null, 'sys:param:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (48, 45, '修改', null, 'sys:param:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (49, 45, '删除', null, 'sys:param:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (50, 43, '标签管理', 'operation/tag', null, 1, 'tag', 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (51, 50, '查看', null, 'operation:tag:list,operation:tag:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (52, 50, '新增', null, 'operation:tag:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (53, 50, '修改', null, 'operation:tag:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (54, 50, '删除', null, 'operation:tag:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (61, 66, '图书管理', 'book/book', null, 1, 'list', 3);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (62, 61, '查看', null, 'book:list,book:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (63, 61, '新增', null, 'book:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (64, 61, '修改', null, 'book:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (65, 61, '删除', null, 'book:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (66, 0, '阅读管理', null, null, 0, 'read', 1);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (67, 66, '新增图书', 'book/book-add-or-update', '', 1, 'add', 1);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (68, 66, '笔记管理', 'book/note', null, 1, 'list', 2);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (69, 68, '查看', null, 'book:note:list,book:note:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (70, 68, '新增', null, 'book:note:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (71, 68, '修改', null, 'book:note:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (72, 68, '删除', null, 'book:note:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (73, 66, '新增笔记', 'book/note-add-or-update', '', 1, 'add', 0);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (74, 43, '友链管理', 'operation/link', null, 1, 'link', 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (75, 74, '查看', null, 'operation:link:list,operation:link:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (76, 74, '新增', null, 'operation:link:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (77, 74, '修改', null, 'operation:link:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (78, 74, '删除', null, 'operation:link:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (79, 43, '推荐管理', 'operation/recommend', null, 1, 'recommend', 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (80, 79, '查看', null, 'operation:recommend:list,operation:recommend:info', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (81, 79, '新增', null, 'operation:recommend:save', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (82, 79, '修改', null, 'operation:recommend:update', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (83, 79, '删除', null, 'operation:recommend:delete', 2, null, 6);
INSERT INTO  sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (84, 32, '刷新缓存', null, 'article:cache:refresh', 2, null, 0);

create table sys_param
(
  id bigint auto_increment primary key,
  par_key int null,
  par_value varchar(255) null,
  menu_url varchar(255) null,
  type varchar(255) null
) comment '系统参数';

INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (2, 0, '一级', '/operation-category', 'CATEGORY_RANK');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (3, 1, '二级', '/operation-category', 'CATEGORY_RANK');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (4, 2, '三级', '/operation-category', 'CATEGORY_RANK');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (7, 0, '小图片', '/article-addOrUpdate', 'ARTICLE_COVER_TYPE');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (8, 1, '大图片', '/article-addOrUpdate', 'ARTICLE_COVER_TYPE');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (9, 2, '无图片', '/article-addOrUpdate', 'ARTICLE_COVER_TYPE');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (10, 0, '文章', null, 'MODULE_TYPE');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (11, 1, '图书', null, 'MODULE_TYPE');
INSERT INTO  sys_param (id, par_key, par_value, menu_url, type) VALUES (12, 2, '笔记', null, 'MODULE_TYPE');

create table sys_role
(
  role_id bigint auto_increment primary key,
  role_name varchar(100) null comment '角色名称',
  remark varchar(100) null comment '备注',
  create_user_id bigint null comment '创建者ID',
  create_time datetime null comment '创建时间'
) comment '角色';

create table sys_role_menu
(
  id bigint auto_increment primary key,
  role_id bigint null comment '角色ID',
  menu_id bigint null comment '菜单ID'
) comment '角色与菜单对应关系';

create table sys_user
(
  user_id bigint auto_increment primary key,
  username tinytext null,
  password varchar(255) null,
  email tinytext null,
  salt tinytext null,
  create_user_id tinytext null,
  create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
  status tinyint null
);

INSERT INTO sys_user (user_id, username, password, email, salt, create_user_id, create_time, status) VALUES (1, 'admin', 'cdac762d0ba79875489f6a8b430fa8b5dfe0cdd81da38b80f02f33328af7fd4a', '***@qq.com', 'YzcmCZNvbXocrsz9dm8e', '1', now(), 1);

create table sys_user_role
(
  id bigint auto_increment primary key,
  user_id bigint null comment '用户ID',
  role_id bigint null comment '角色ID'
) comment '用户与角色对应关系';

create table tag
(
  id int auto_increment primary key,
  name varchar(50) null comment '标签名字',
  type int null comment '所属类别：0文章，1类别'
) comment '标签';

INSERT INTO tag (id, name, type) VALUES (1, '本站相关', 0);
INSERT INTO tag (id, name, type) VALUES (2, '关于', 0);

create table tag_link
(
  id int auto_increment comment '主键' primary key,
  tag_id int null comment '标签Id',
  link_id int null comment '关联Id',
  type int null comment '所属类别：0文章，1阅读'
) comment '标签多对多维护表';


INSERT INTO tag_link (id, tag_id, link_id, type) VALUES (1, 1, 1, 0);
INSERT INTO tag_link (id, tag_id, link_id, type) VALUES (2, 2, 1, 0);

