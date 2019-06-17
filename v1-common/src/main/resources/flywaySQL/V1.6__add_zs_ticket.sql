alter table zs_product add unit_price decimal(20,4) DEFAULT NULL COMMENT '单价';
alter table zs_product add money decimal(20,4) DEFAULT NULL COMMENT '金额';
alter table zs_product add unit varchar(20) DEFAULT NULL COMMENT '单位';

alter table zs_ticket add earnest decimal(20,4) DEFAULT NULL COMMENT '定金';
alter table zs_ticket add payment decimal(20,4) DEFAULT NULL COMMENT '尾款';
alter table zs_ticket add back_describe varchar(2000) DEFAULT NULL COMMENT '回单描述';

