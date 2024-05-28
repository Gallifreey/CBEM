<script setup lang="ts">
import Table from '@/components/table/index.vue'
defineOptions({
  name: 'Analysis',
})

</script>

<template>
  <page-container>
    <Suspense :fallback="null">
      <Table />
    </Suspense>
  </page-container>
</template>
