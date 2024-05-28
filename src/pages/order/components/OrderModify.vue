<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-modal title="订单信息修改" width="85%" v-model:open="openE" :closable="false">
    <a-form :model="formState">
      <a-descriptions bordered>
        <a-descriptions-item label="订单描述" :span="3">
          <TransparentInput v-model:value="formState.description" width="100%" />
        </a-descriptions-item>
        <a-descriptions-item label="接收方" :span="2">
          <TransparentInput v-model:value="formState.target" width="100%"/>
        </a-descriptions-item>
        <a-descriptions-item label="发送方" :span="2">
          <TransparentInput v-model:value="formState.source" width="100%"/>
        </a-descriptions-item>
        <a-descriptions-item label="物品清单" :span="5">
          <a-table :columns="VendorOrderBOMListColumn">
            
          </a-table>
        </a-descriptions-item>
        <a-descriptions-item label="备注" :span="5">
          <TransparentInput v-model:value="formState.memo" width="100%" type="textarea"/>
        </a-descriptions-item>
      </a-descriptions>
    </a-form>
  </a-modal>
</template>
<script lang="ts" setup>
import TransparentInput from '~@/components/utils/TransparentInput.vue';
import { VendorOrderBOMListColumn } from '~@/utils/columns';
import { objectValuesArrayFilter } from '~@/utils/tools';

const props = defineProps({
  data: {
    type: Object
  },
  open: {
    type: Boolean,
    default: false
  }
})
const emits = defineEmits(['update:open']);
const openE = useVModel(props, 'open', emits);
interface FormState {
  description: string,
  source: string,
  target: string,
  memo: string
}
const formState = ref<FormState>({
  description: "113",
  source: "1",
  target: "2",
  memo: "111"
})
objectValuesArrayFilter(VendorOrderBOMListColumn, ['id'], ['dataIndex'])
</script>
<style lang="less" scoped>

</style>