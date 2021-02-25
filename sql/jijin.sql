CREATE TABLE `jijin_shouyi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) DEFAULT NULL COMMENT '基金代码',
  `name` varchar(255) DEFAULT NULL COMMENT '基金名称',
  `estimate_value` varchar(255) DEFAULT NULL,
  `real_value` varchar(255) DEFAULT NULL COMMENT '最新净值',
  `estimate_rate` varchar(255) DEFAULT NULL,
  `real_rate` varchar(255) DEFAULT NULL COMMENT '当前持有份额',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `credate_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收益记录';


CREATE TABLE `jijin_maichu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) DEFAULT NULL COMMENT '基金代码',
  `name` varchar(255) DEFAULT NULL COMMENT '基金名称',
  `real_value` varchar(255) DEFAULT NULL COMMENT '卖出时净值',
  `number` varchar(255) DEFAULT NULL COMMENT '卖出份额',
  `amount` varchar(255) DEFAULT NULL COMMENT '卖出金额',
  `charge` varchar(255) DEFAULT NULL COMMENT '手续费',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖出基金';

CREATE TABLE `jijin_mairu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) DEFAULT NULL COMMENT '基金代码',
  `name` varchar(255) DEFAULT NULL COMMENT '基金名称',
  `real_value` varchar(255) DEFAULT NULL COMMENT '买入时净值',
  `number` varchar(255) DEFAULT NULL COMMENT '买入份额',
  `amount` varchar(255) DEFAULT NULL COMMENT '买入金额',
  `charge` varchar(255) DEFAULT NULL COMMENT '手续费',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `credate_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='买入基金';

CREATE TABLE `jijin_shouyi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) DEFAULT NULL COMMENT '基金代码',
  `name` varchar(255) DEFAULT NULL COMMENT '基金名称',
  `estimate_value` varchar(255) DEFAULT NULL,
  `real_value` varchar(255) DEFAULT NULL COMMENT '最新净值',
  `estimate_rate` varchar(255) DEFAULT NULL,
  `real_rate` varchar(255) DEFAULT NULL COMMENT '当前持有份额',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `credate_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收益记录';