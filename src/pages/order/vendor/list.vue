<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <page-container>
     <template #content>
       <a-form :model="formState">
         <a-row :gutter="[30, 0]">
           <a-col :span="8">
             <a-form-item name="source" label="发送方">
               <a-input v-model:value="formState.source"/>
             </a-form-item>
           </a-col>
           <a-col :span="8">
             <a-form-item name="target" label="接收方">
               <a-input v-model:value="formState.target"/>
             </a-form-item>
           </a-col>
           <a-col :span="8">
             <a-form-item name="publishTime" label="创建时间">
               <a-range-picker v-model:value="formState.publishTime" style="width: 100%;" />
             </a-form-item>
           </a-col>
         </a-row>
         <a-row>
           <a-space>
             <a-form-item>
               <a-button v-if="rowSelectedKeys.length !== 0" danger @click="handleDelete(rowSelectedKeys)" >批量删除 - ( {{ rowSelectedKeys.length }} 个订单)</a-button>
             </a-form-item>
             <a-form-item>
               <a-button>打印订单</a-button>
             </a-form-item>
             <a-form-item>
               <a-button type="primary">添加订单</a-button>
             </a-form-item>
             <a-form-item>
               <a-button type="primary" html-type="submit" @click="handleQuery">查询</a-button>
             </a-form-item>
           </a-space>
         </a-row>
       </a-form>
     </template>
     <a-table :columns="VendorOrderColumn" :data-source="orders" :row-selection="rowSelection" :scroll="{ x: 1300}">
       <template #bodyCell="{record, column}">
         <template v-if="column.dataIndex === 'state'">
            <ColorfulTag :text="ORDER_STATUS_ARRAY[record.state]" :number="record.state"/>
         </template>
         <template v-if="column.dataIndex === 'action'">
           <a-space>
             <a-button size="small" type="link" @click="openHandler.open1 = true">预览</a-button>
             <a-button size="small" type="link" @click="openHandler.open2 = true">清单</a-button>
             <a-button size="small" type="link" @click="openHandler.open3 = true">修改</a-button>
             <a-popconfirm
             title="确定要删除此订单吗?"
             @confirm="handleDelete(record.key)"
             >
              <a-button size="small" type="link" danger>删除</a-button>
             </a-popconfirm>
           </a-space>
         </template>
       </template>
     </a-table>
     <OrderModal v-model:open="openHandler.open1" />
     <OrderBOM v-model:open="openHandler.open2" />
     <OrderModify v-model:open="openHandler.open3" />
   </page-container>
 </template>
 <script lang="ts" setup>
 import { RangeValue } from '~@/types/form';
 import { VendorOrderColumnType, VendorOrderColumn } from '~@/utils/columns';
 import { useAntRowSelection } from '~@/utils/tools'
 import dayjs from 'dayjs';
 import ColorfulTag from '~@/components/utils/ColorfulTag.vue';
 import { ORDER_STATUS_ARRAY } from '~@/utils/constant'
 import OrderModal from '../components/OrderModal.vue'
 import OrderBOM from '../components/OrderBOM.vue'
 import OrderModify from '../components/OrderModify.vue'
import { deleteOrderApi, getOrdersByQueryApi, getOrdersByUIDApi } from '~@/api/common/order';
import { message } from 'ant-design-vue';

 interface FormState {
   source: string,
   target: string,
   publishTime: RangeValue
 }
 const formState = ref<FormState>({
   source: "",
   target: "",
   publishTime: [dayjs("2015/01/01"), dayjs("2015/01/01")],
 })
 const openHandler = ref({
  open1: false,
  open2: false,
  open3: false
 })
 const orders = ref<VendorOrderColumnType[]>([
   {
     key: 1,
     name: '仓库一',
     description: '东风街',
     target: "1",
     source: "1",
     publishTime: "1111/1111/11 1:2:3",
     state: 2
   },
   {
     key: 2,
     name: '仓库一',
     description: '东风街',
     target: "1",
     source: "1",
     publishTime: "1111/1111/11 1:2:3",
     state: 1
   }
 ])
 const rowSelectedKeys = ref([])
 const rowSelection = useAntRowSelection<VendorOrderColumnType>(rowSelectedKeys);
 async function handleInit(){
  const { code, data } = await getOrdersByUIDApi({
    uid: 1
  });
  if(code !== 0) orders.value = data;
 }
 async function handleQuery(){
  const { code, data } = await getOrdersByQueryApi(formState.value);
  if(code !== 0) orders.value = data;
 }
 async function handleDelete(id: number | string | number[] | string[]){
  const { code } = await deleteOrderApi({
    id: id
  });
  if(code !== 0) message.success("订单删除成功！")
  else message.error("订单删除失败！")
 }
 onMounted(() => {
  handleInit()
 })
 </script>
 <style lang="less" scoped>
 
 </style>