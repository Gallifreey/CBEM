export enum AccessEnum {
  ADMIN = 'ADMIN', // 管理员
  VENDOR = 'VENDOR', // 供应商
  STORAGE_MANAGER = 'STORAGE_MANAGER', // 仓库管理者
  SALER = 'SALER' // 销售员
}

export enum DynamicLoadEnum {
  FRONTEND = 'FRONTEND', // 前端动态加载菜单，使用这种方式将从dynamic-routes.ts中加载菜单和路由信息
  BACKEND = 'BACKEND', // 后端动态加载菜单， 使用这种方式将从后端接口加载菜单和路由信息
}

export enum STATUS {
  OFF = '0',
  RUNNING = '1',
  ONLINE = '2',
  ERROR = '3',
}
// 默认情况下我们提供从后端加载的逻辑
export const DYNAMIC_LOAD_WAY = import.meta.env.VITE_APP_LOAD_ROUTE_WAY ?? DynamicLoadEnum.BACKEND

// 订单状态
export enum ORDER_STATUS {
  NEED_PAY = 0,
  PAYED = 1,
  ARCHIVED = 2,
  CANCLED = 3,
  REFUND = 4,
}

export const ORDER_STATUS_ARRAY = ["待付款", "已付款", "已归档", "已取消", "已退款"]

export const DILIVERY_TYPE = ["海运", "空运", "陆运", "自取", "传真"]

// 退换货状态
export enum RAE_STATUS {
  NEED_RETURN = 1,
  NEED_EXCHANGE = 2,
  RETURNED = 3,
  EXCHANGED = 4,
  CANCLED = 5
}
export const RAE_STATUS_ARRAY = ["申请退货", "申请换货", "已退货", "已换货", "已取消"]

export const ROLES_ARRAY = ['ADMIN', 'VENDOR', 'STORAGE_MANAGER', 'SALER']