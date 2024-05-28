<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-drawer v-model:open="openE" title="物料清单" width="50%">
    <div class="info-panel">
      <a-table :columns="VendorOrderBOMListColumn" :data-source="data">

      </a-table>
    </div>
  </a-drawer>
</template>
<script lang="ts" setup>
 import { VendorOrderBOMListColumn } from '~@/utils/columns';
import { addIncreasedNumber } from '~@/utils/tools';

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
const data = ref([
  {
    name: "1",
    code: "1111",
    unit: "包",
    price: 17.5,
    total: 20
  },
  {
    name: "1",
    code: "1111",
    unit: "包",
    price: 17.5,
    total: 20
  }
])
addIncreasedNumber(data.value)
</script>
<style lang="less" scoped>

</style>