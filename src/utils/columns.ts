import { TableColumnType } from "ant-design-vue";
import dayjs, { Dayjs } from "dayjs";

// Vendor Commodity Table
export type CommdityColumnType = {
    name: string,
    salePrice: number,
    brand: string,
    deliveryState: string,
    unit: string,
    weight: number,
    color: string,
    size: string,
    barCodeMsg: string,
    publishTime: string,
    status?: boolean,
    key?: number
}
export const CommdityColumn: TableColumnType<CommdityColumnType>[] = [
    {
        dataIndex: 'name',
        title: '商品名称',
        align: 'center',
        width: 150,
        fixed: 'left'
    },
    {
        dataIndex: 'salePrice',
        title: '销售价',
        align: 'center'
    },
    {
        dataIndex: 'brand',
        title: '品牌',
        align: 'center'
    },
    {
        dataIndex: 'deliveryState',
        title: '递送方式',
        align: 'center'
    },
    {
        dataIndex: 'unit',
        title: '单位',
        align: 'center'
    },
    {
        dataIndex: 'weight',
        title: '重量',
        align: 'center'
    },
    {
        dataIndex: 'color',
        title: '颜色',
        align: 'center'
    },
    {
        dataIndex: 'size',
        title: '尺寸',
        align: 'center'
    },
    {
        dataIndex: 'barCodeMsg',
        title: '条形码',
        width: 200,
        align: 'center'
    },
    {
        dataIndex: 'publishTime',
        title: '发布时间',
        width: 170,
        align: 'center'
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 200,
        fixed: 'right'
    }
]

// Vendor Auth-Storage Table
export type VendorStorageColumnType = {
    name: string,
    address: string,
    brand: string,
    remained: number,
    key?: number
}

export const VendorStorageColumn: TableColumnType<VendorStorageColumnType>[] = [
    {
        dataIndex: 'name',
        title: '仓库名称',
        align: 'center',
        width: 150,
        fixed: 'left'
    },
    {
        dataIndex: 'address',
        title: '仓库地址',
        align: 'center',
        width: 300
    },
    {
        dataIndex: 'brand',
        title: '授权品牌',
        align: 'center',
    },
    {
        dataIndex: 'remained',
        title: '库存容量',
        align: 'center'
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 150,
        fixed: 'right'
    }
]

// Vendor Order Table
export type VendorOrderColumnType = {
    name: string,
    description: string,
    source: string,
    target: string,
    publishTime: string,
    state: number,
    key?: number
}

export const VendorOrderColumn: TableColumnType<VendorOrderColumnType>[] = [
    {
        dataIndex: 'name',
        title: '订单序列号',
        align: 'center',
        width: 150,
        fixed: 'left'
    },
    {
        dataIndex: 'description',
        title: '订单描述',
        align: 'center',
        width: 300
    },
    {
        dataIndex: 'source',
        title: '订单发起人',
        width: 150,
        align: 'center',
    },
    {
        dataIndex: 'target',
        title: '订单接收人',
        width: 150,
        align: 'center'
    },
    {
        dataIndex: 'publishTime',
        title: '订单创建时间',
        align: 'center',
        width: 200,
    },
    {
        dataIndex: 'state',
        title: '订单状态',
        align: 'center',
        width: 150,
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 250,
        fixed: 'right'
    }
]

// Vendor Order BOMlist type
export type VendorOrderBOMListColumnType = {
    name: string,
    code: string,
    total: number,
    price: number,
    unit: string
}

export const VendorOrderBOMListColumn: TableColumnType<VendorOrderBOMListColumnType>[] = [
    {
        dataIndex: 'id',
        title: '序号',
        align: 'center'
    },
    {
        dataIndex: 'code',
        title: '物品编码',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'name',
        title: '物品名称',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'unit',
        title: '单位',
        align: 'center'
    },
    {
        dataIndex: 'price',
        title: '单价',
        align: 'center'
    },
    {
        dataIndex: 'total',
        title: '数量',
        align: 'center'
    },
]

// Vendor Order Finance WaterFall Type
export type VendorOrderWaterFallColumnType =  {
    id: String,
    name: String,
    publishTime: String,
    price: Number,
    payTime: String,
    status: Number
}

export const VendorOrderWaterFallColumn: TableColumnType<VendorOrderWaterFallColumnType>[] = [
    {
        dataIndex: 'id',
        title: '订单序列号',
        align: 'center',
        width: 200,
        fixed: 'left'
    },
    {
        dataIndex: 'name',
        title: '商品名称',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'price',
        title: '订单金额',
        align: 'center',
        width: 100
    },
    {
        dataIndex: 'status',
        title: '订单状态',
        align: 'center',
        width: 100
    },
    {
        dataIndex: 'publishTime',
        title: '下单时间',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'payTime',
        title: '付款时间',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 200,
        fixed: 'right'
    }
]

// saler RAE Table
export type SalerReturnAndExchangeColumnType = {
    price: number,
    orderId: string,
    user: string,
    publishTime: Dayjs,
    state: number,
    key?: number
}

export const SalerRAEColumn: TableColumnType<SalerReturnAndExchangeColumnType>[] = [
    {
        dataIndex: 'orderId',
        title: '订单序列号',
        align: 'center',
        width: 200,
        fixed: 'left'
    },
    {
        dataIndex: 'user',
        title: '用户名称',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'price',
        title: '订单金额',
        align: 'center',
        width: 100
    },
    {
        dataIndex: 'state',
        title: '退换货状态',
        align: 'center',
        width: 100
    },
    {
        dataIndex: 'publishTime',
        title: '退换货时间',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 200,
        fixed: 'right'
    }
]

// storage manager table
export type StorageManagerStorageManagementType = {
    key?: number,
    name: string,
    address: string,
    authTime: Dayjs
}

export const StorageManagementColumns: TableColumnType<StorageManagerStorageManagementType>[] = [
    {
        dataIndex: 'name',
        title: '仓库名称',
        align: 'center',
        width: 400,
        fixed: 'left'
    },
    {
        dataIndex: 'address',
        title: '仓库地址',
        align: 'center',
        width: 400,
    },
    {
        dataIndex: 'authTime',
        title: '授权时间',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center'
    }
]

// storage manager io table
export type StorageManagerIOType = {
    date: Dayjs,
    name: string,
    size: string,
    unit: string,
    in: number,
    out: number,
    remained: number
    key?: number
}

export const StorageManagerIOColumn: TableColumnType<StorageManagerIOType>[] = [
    {
        dataIndex: 'name',
        title: '商品名称',
        align: 'center',
        width: 200,
        fixed: 'left'
    },
    {
        dataIndex: 'size',
        title: '规格',
        align: 'center',
        width: 200,
    },
    {
        dataIndex: 'unit',
        title: '单位',
        align: 'center'
    },
    {
        dataIndex: 'in',
        title: '入库数量',
        align: 'center'
    },
    {
        dataIndex: 'out',
        title: '出库数量',
        align: 'center'
    },
    {
        dataIndex: 'remained',
        title: '剩余库存',
        align: 'center'
    },
    {
        dataIndex: 'date',
        title: '操作时间',
        align: 'center',
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        fixed: 'right',
        width: 200,
    }
]

// storage manager brand table
export type StorageManagerBrandType = {
    key?: number,
    authTime: Dayjs,
    name: string,
    picture?: string
}

export const StorageManagerBrandColumn: TableColumnType<StorageManagerBrandType>[] = [
    {
        dataIndex: 'name',
        title: '品牌名称',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'authTime',
        title: '授权时间',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'picture',
        title: '品牌缩略图',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 100
    }
]

// storage manager storage table
export type StorageManagerStorageType = {
    key?: number,
    name: string,
    brand: string,
    description: string,
    remained: number,
    publishTime: Dayjs,
    picture: string,
    price: number,
}

export const StorageManagerStorageColumn: TableColumnType<StorageManagerStorageType>[] = [
    {
        dataIndex: 'name',
        title: '商品名称',
        align: 'center',
        width: 200,
        fixed: 'left'
    },
    {
        dataIndex: 'brand',
        title: '商品品牌',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'description',
        title: '商品描述',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'price',
        title: '商品价格',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'remained',
        title: '库存剩余',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'publishTime',
        title: '发布时间',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'picture',
        title: '缩略图',
        align: 'center',
        width: 150
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 150,
        fixed: 'right'
    }
]

export type OrderPaymentWaterfallType = {
    key?: number,
    orderID: number,
    total: number,
    type: number,
    name: string,
    paymentDate: Dayjs
}

export const OrderPaymentWaterfallColumn: TableColumnType<OrderPaymentWaterfallType>[] = [
    {
        dataIndex: 'orderID',
        title: '订单编号',
        align: 'center',
        width: 200,
        fixed: 'left'
    },
    {
        dataIndex: 'name',
        title: '商户名',
        align: 'center',
        width: 200,
    },
    {
        dataIndex: 'price',
        title: '金额',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'type',
        title: '交易类型',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'paymentDate',
        title: '交易日期',
        align: 'center',
        width: 200
    },
    {
        dataIndex: 'action',
        title: '操作',
        align: 'center',
        width: 200,
        fixed: 'right'
    }
]