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
              <a-select v-model:value="formState.brand" :options="brandData"/>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="deliveryState" label="递送方式">
              <a-select v-model:value="formState.deliveryState" :options="deliveryStateData"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="[30, 0]">
          <a-col :span="8">
            <a-form-item name="publishTime" label="发布时间">
              <a-range-picker v-model:value="formState.publishTime" />
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="salePrice" label="销售价">
              <a-input-number style="width: 100%" type="number" v-model:value="formState.salePrice"/>
            </a-form-item>
          </a-col>
          <Access :access="'SALER'">
            <a-col :span="8">
              <a-form-item name="status" label="上货状态">
                <a-select  v-model:value="formState.status"/>
              </a-form-item>
            </a-col>
          </Access>
        </a-row>
        <a-row>
          <a-space>
            <a-form-item>
              <a-button v-if="rowSelectedKeys.length>=1" :disabled="rowSelectedKeys.length === 0" danger @click="deleteDataByArray">
                删除 - 选中 {{ rowSelectedKeys.length }} 个项目
              </a-button>
            </a-form-item>
            <a-form-item>
              <a-button html-type="submit" @click="addNewCommodity()">添加新的商品</a-button>
            </a-form-item>
            <a-form-item>
              <a-button type="primary" html-type="submit" @click="queryData">查询</a-button>
            </a-form-item>
          </a-space>
        </a-row>
      </a-form>
    </template>
    <a-table :columns="CommdityColumn" :data-source="dataFrame" :row-selection="rowSelection" :scroll="{ x: 1400}">
      <template #bodyCell="{column, record}">
        <template v-if="column.dataIndex === 'barCodeMsg'">
          <svg class="barcode"></svg>
        </template>
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <Access :access="'SALER'">
              <a v-if="record.status">上架</a>
              <a v-else>下架</a>
            </Access>
            <a @click="drawerOpen = true">审阅</a>
            <a>修改</a>
            <a-popconfirm title="确认删除所选商品" @confirm="deleteDataPerRow(record.key)">
              <a>删除</a>
            </a-popconfirm>
          </a-space>
        </template>
      </template>
    </a-table>
    <CommodityDetailDrawer v-model:open="drawerOpen" :id="1"/>
  </page-container>
</template>
<script lang="ts" setup>
import JsBarcode from 'jsbarcode';
import CommodityDetailDrawer from './components/CommodityDetailDrawer.vue';
import dayjs from 'dayjs';
import { CommdityColumnType, CommdityColumn } from '~@/utils/columns';
import { useAntRowSelection } from '~@/utils/tools'
import { RangeValue } from '~@/types/form';
import { deleteCommodity, getCommodityListByUID, queryCommodity } from '~@/api/common/commodity';
import { message } from 'ant-design-vue';
import { getAllBrand, getAllDeliveryState } from '~@/api/common/utils';

interface FormState {
  name: string,
  brand: string,
  deliveryState: string,
  publishTime: RangeValue,
  salePrice: number,
  status: string,
}
const formState = ref<FormState>({
  name: "",
  brand: "",
  deliveryState: "",
  publishTime: [dayjs("2015/01/01"), dayjs("2015/01/01")],
  salePrice: 0,
  status: "off"
})
const drawerOpen = ref(false);
const dataFrame = shallowRef<CommdityColumnType[]>([
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
    publishTime: '2024/5/9 11:11:11',
    status: true,
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
    publishTime: '2024/5/9 11:11:11',
    status: false,
  }
])
async function loadData(){
  const { data } = await getCommodityListByUID(1);
  if(data) dataFrame.value = data;
}
async function queryData(){
  const { data } = await queryCommodity(formState.value);
  if(data) dataFrame.value = data;
}
async function deleteDataPerRow(id: number){
  const { code } = await deleteCommodity([id]);
  if(code === 0) message.error("删除失败")
  else message.success("删除成功")
}
async function deleteDataByArray(){
  if(rowSelectedKeys.value){
    const { code } = await deleteCommodity(rowSelectedKeys.value);
    if(code === 0) message.error("删除失败")
    else message.success("删除成功")
  }
}
const router = useRouter();
const addNewCommodity = () => {
  router.push({
    path: '/commodity/form'
  })
}
const brandData = ref();
const deliveryStateData = ref();
async function getBrandData(){
  const { data } = await getAllBrand();
  if(data) brandData.value = data;
}
async function getDeliveryStateData(){
  const { data } = await getAllDeliveryState();
  if(data) deliveryStateData.value = data;
}
const rowSelectedKeys = ref<(String[] | Number[])>([]);
const rowSelection = useAntRowSelection<CommdityColumnType>(rowSelectedKeys);
  onMounted(() => {
  loadData();
  getBrandData();
  getDeliveryStateData();
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
</script>
<style lang="less" scoped>

</style>