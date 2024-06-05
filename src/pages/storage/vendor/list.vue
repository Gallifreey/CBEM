<!-- eslint-disable vue/multi-word-component-names -->
<template>
 <page-container>
    <template #content>
      <a-form :model="formState">
        <a-row :gutter="[30, 0]">
          <a-col :span="8">
            <a-form-item name="name" label="仓库名称">
              <a-input v-model:value="formState.name"/>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="brand" label="授权品牌">
              <a-input v-model:value="formState.brand"/>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="authTime" label="授权时间">
              <a-range-picker v-model:value="formState.authTime" />
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-space>
            <a-form-item>
              <a-button @click="handleAuth">授权新的仓库</a-button>
            </a-form-item>
            <a-form-item>
              <a-button type="primary" html-type="submit" @click="queryData()">查询</a-button>
            </a-form-item>
          </a-space>
        </a-row>
      </a-form>
    </template>
    <a-table :columns="VendorStorageColumn" :data-source="dataFrame" :row-selection="rowSelection">
      <template #bodyCell={column}>
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <a>修改</a>
            <a>删除</a>
          </a-space>
        </template>
      </template>
    </a-table>
  </page-container>
</template>
<script lang="ts" setup>
import { RangeValue } from '~@/types/form';
import { VendorStorageColumnType, VendorStorageColumn } from '~@/utils/columns';
import { useAntRowSelection } from '~@/utils/tools'
import dayjs from 'dayjs';
import { getAuthedStorageList, queryStorage } from '~@/api/common/storage';

const router = useRouter();
interface FormState {
  name: string,
  brand: string,
  authTime: RangeValue
}
const formState = ref<FormState>({
  name: "",
  brand: "",
  authTime: [dayjs("2015/01/01"), dayjs("2015/01/01")],
})
const dataFrame = shallowRef<VendorStorageColumnType[]>([
  {
    key: 1,
    name: '仓库一',
    address: '东风街',
    brand: '你好',
    remained: 56
  },
  {
    key: 2,
    name: '仓库二',
    address: '东风街',
    brand: '你好',
    remained: 56
  }
])
const rowSelectonKeys = ref([])
const rowSelection = useAntRowSelection<VendorStorageColumnType>(rowSelectonKeys);
const handleAuth = () => {
  router.push({
    path: '/storage/vendor/auth'
  })
}
async function laodData(){
  const { data } = await getAuthedStorageList(1);
  if(data) dataFrame.value = data;
}
async function queryData(){
  const { data } = await queryStorage(formState.value);
  if(data) dataFrame.value = data;
}
onMounted(() => {
  laodData();
})
</script>
<style lang="less" scoped>

</style>