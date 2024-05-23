import { TableColumnType } from "ant-design-vue";

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
        width: 150,
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
        align: 'center',
    },
    {
        dataIndex: 'target',
        title: '订单接收人',
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
        width: 150,
        fixed: 'right'
    }
]