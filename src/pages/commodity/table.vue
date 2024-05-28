<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <page-container>
    <template #content>
      <a-form :model="formState">
        <a-row :gutter="[30, 0]">
          <a-col :span="8">
            <a-form-item name="name" label="商品名称">
              <a-input v-model:value="formState.name"/>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="brand" label="品牌">
              <a-input v-model:value="formState.brand"/>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="deliveryState" label="递送方式">
              <a-input v-model:value="formState.deliveryState"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="8">
            <a-form-item name="publishTime" label="发布时间">
              <a-range-picker v-model:value="formState.publishTime" />
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="salePrice" label="销售价">
              <a-input-number type="number" v-model:value="formState.salePrice"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-space>
            <a-form-item>
              <a-button :disabled="rowSelectedKeys.length === 0">
                删除 - 选中{{ rowSelectedKeys.length }} 个项目
              </a-button>
            </a-form-item>
            <a-form-item>
              <a-button html-type="submit">添加新的商品</a-button>
            </a-form-item>
            <a-form-item>
              <a-button type="primary" html-type="submit">查询</a-button>
            </a-form-item>
          </a-space>
        </a-row>
      </a-form>
    </template>
    <a-table :columns="CommdityColumn" :data-source="data" :row-selection="rowSelection" :scroll="{ x: 1400}">
      <template #bodyCell={column}>
        <template v-if="column.dataIndex === 'barCodeMsg'">
          <svg class="barcode"></svg>
        </template>
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <a>上架</a>
            <a @click="drawerOpen = true">审阅</a>
            <a>修改</a>
            <a-popconfirm title="确认删除所选商品">
              <a>删除</a>
            </a-popconfirm>
          </a-space>
        </template>
      </template>
    </a-table>
    <CommodityDetailDrawer v-model:open="drawerOpen"/>
  </page-container>
</template>
<script lang="ts" setup>
import JsBarcode from 'jsbarcode';
import CommodityDetailDrawer from './components/CommodityDetailDrawer.vue';
import dayjs from 'dayjs';
import { CommdityColumnType, CommdityColumn } from '~@/utils/columns';
import { useAntRowSelection } from '~@/utils/tools'
import { RangeValue } from '~@/types/form';

interface FormState {
  name: string,
  brand: string,
  deliveryState: string,
  publishTime: RangeValue,
  salePrice: number
}
const formState = ref<FormState>({
  name: "",
  brand: "",
  deliveryState: "",
  publishTime: [dayjs("2015/01/01"), dayjs("2015/01/01")],
  salePrice: 0,
})
const drawerOpen = ref(false);
const data = shallowRef<CommdityColumnType[]>([
  {
    key: 1,
    name: 'ABC',
    salePrice: 0,
    brand: '无品牌',
    deliveryState: 'SF',
    unit: '包',
    weight: 1.2,
    color: '红色',
    size: '3*3*3m',
    barCodeMsg: '',
    publishTime: '2024/5/9 11:11:11'
  },
  {
    key: 2,
    name: 'ABC',
    salePrice: 0,
    brand: '无品牌',
    deliveryState: 'SF',
    unit: '包',
    weight: 1.2,
    color: '红色',
    size: '3*3*3m',
    barCodeMsg: '',
    publishTime: '2024/5/9 11:11:11'
  }
])
onMounted(() => {
  nextTick(() => {
    JsBarcode('.barcode', '123456', {
      format: 'CODE39',
      width:1,
      height:40,
      displayValue:true,
      fontSize:15,
      margin:15,
      background: "transparent"
    })
  })
})
const rowSelectedKeys = ref<(String | Number)[]>([]);
const rowSelection = useAntRowSelection<CommdityColumnType>(rowSelectedKeys);
</script>
<style lang="less" scoped>

</style>