
USE `boo`;

-- -----------------------------------------------------
-- Table `boo`.`t_base_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boo`.`t_base_user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
  `name` VARCHAR(64) NOT NULL COMMENT '姓名',
  `password` VARCHAR(256) NOT NULL COMMENT '密码',
  `account` VARCHAR(64) NOT NULL COMMENT '账户',
  `email` VARCHAR(128) NOT NULL COMMENT '邮箱',
  `user_status` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '用户状态：1：正常；0：禁用',
  `del_flag` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '删除标识：1：未删除；0：已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_user_id` (`user_id` ASC),
  UNIQUE INDEX `UK_account` (`account` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '用户';


-- -----------------------------------------------------
-- Table `boo`.`t_base_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boo`.`t_base_menu` (
  `id` INT NOT NULL COMMENT 'ID',
  `menu_id` BIGINT(20) NOT NULL COMMENT '菜单id',
  `parent_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '父id',
  `name` VARCHAR(64) NOT NULL COMMENT '菜单名称',
  `path` VARCHAR(256) NOT NULL COMMENT '访问路径',
  `menu_type` TINYINT(1) NOT NULL DEFAULT 2 COMMENT '菜单类型；1：目录；2：菜单；3：链接',
  `icon` VARCHAR(32) NULL COMMENT '菜单图标',
  `sort` TINYINT(3) NOT NULL DEFAULT 0 COMMENT '排序',
  `del_flag` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '删除标识：1：未删除；0：已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `menu_id_UNIQUE` (`menu_id` ASC))
ENGINE = InnoDB
COMMENT = '菜单';


-- -----------------------------------------------------
-- Table `boo`.`t_base_role_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boo`.`t_base_role_menu` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '用户',
  `role_id` BIGINT(20) NOT NULL COMMENT '角色id',
  `menu_id` BIGINT(20) NOT NULL COMMENT '菜单id',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_menu_UNIQUE` (`role_id`, `menu_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '角色-菜单 关系';


-- -----------------------------------------------------
-- Table `boo`.`t_base_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boo`.`t_base_role` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` BIGINT(20) NOT NULL COMMENT '角色id',
  `name` VARCHAR(64) NOT NULL COMMENT '角色名称',
  `code` VARCHAR(32) NOT NULL COMMENT '角色编码',
  `remark` VARCHAR(256) NULL COMMENT '备注',
  `create_user` VARCHAR(32) NOT NULL COMMENT '创建用户',
  `update_user` VARCHAR(32) NULL DEFAULT 1 COMMENT '更新用户',
  `del_flag` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '删除标识：1：未删除；0：已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_user_id` (`role_id` ASC),
  UNIQUE INDEX `UK_code` (`code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '角色';


-- -----------------------------------------------------
-- Table `boo`.`t_base_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boo`.`t_base_project` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `project_id` BIGINT(20) NOT NULL COMMENT '项目id',
  `name` VARCHAR(64) NOT NULL COMMENT '项目名称',
  `remark` VARCHAR(256) NULL COMMENT '备注',
  `del_flag` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '删除标识：1：未删除；0：已删除',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `project_id_UNIQUE` (`project_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '项目';


-- -----------------------------------------------------
-- Table `boo`.`t_base_user_project_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boo`.`t_base_user_project_role` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_Id` BIGINT(20) NOT NULL COMMENT '用户id',
  `project_id` BIGINT(20) NOT NULL COMMENT '项目id',
  `role_id` BIGINT(20) NOT NULL COMMENT '角色id',
  `default_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '默认标识：0：不是默认；1：默认项目',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_pId_uId_rId` (`user_Id` ASC, `project_id` ASC, `role_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '用户-项目-角色 关系';

