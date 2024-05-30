<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container" ref="refDOM"/>
</template>
<script lang="ts" setup>
import { Pie, PieOptions } from '@antv/g2plot';

const props = defineProps({
  data: {
    type: Object as PropType<Record<string, any>[]>,
    default: () => {
      return {}
    }
  },
  xLabel: {
    type: String,
    default: "date"
  },
  yLabel: {
    type: String,
    default: "value"
  }
})
const refDOM = ref()
const barOptions: PieOptions = {
  data: props.data,
  colorField: props.xLabel,
  angleField: props.yLabel,
}
var barDOM: Pie;
onMounted(() => {
  barDOM = new Pie(refDOM.value, barOptions);
  barDOM.render();
});
watch(() => props.data, (newValue, oldValue) => {
  oldValue
  barDOM.changeData(toRaw(newValue));
  barDOM.render();
});
onUnmounted(() => {
  barDOM.destroy();
});
</script>
<style lang="less" scoped>

</style>