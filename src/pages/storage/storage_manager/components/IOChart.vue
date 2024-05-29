<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <div class="left" ref="leftDOM" style="width: 100%;">

    </div>
  </div>
</template>
<script lang="ts" setup>
import { Bar, BarOptions } from '@antv/g2plot';

type BarData = {
  type: string,
  value: number
}
const props = defineProps({
  data: {
    type: Object as PropType<BarData[]>,
    required: true
  }
})
const leftDOM = ref();
const barOptions: BarOptions = {
  data: props.data,
  padding: 'auto',
  yField: 'type',
  xField: 'value',
}
var barDOMLeft: Bar;
onMounted(() => {
  barDOMLeft = new Bar(leftDOM.value, barOptions);
  barDOMLeft.render();
});
onUnmounted(() => {
  barDOMLeft.destroy();
});
</script>
<style lang="less" scoped>
.container{
  display: flex;
  justify-content: space-between;
}
</style>